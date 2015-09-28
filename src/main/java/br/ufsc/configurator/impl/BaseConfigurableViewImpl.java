package br.ufsc.configurator.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufsc.configurator.api.BaseConfigurableView;
import br.ufsc.configurator.api.FindStrategyHelper;
import br.ufsc.configurator.api.FormField;
import br.ufsc.configurator.api.FormFieldConstant;
import br.ufsc.configurator.api.ViewConfigurator;
import br.ufsc.configurator.api.binder.FieldBinder;
import br.ufsc.configurator.api.builder.ConfiguratorBuilder;
import br.ufsc.configurator.api.converter.CoreWidthConverter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.ViewConfiguration;
import br.ufsc.configurator.api.strategy.CheckBoxStrategy;
import br.ufsc.configurator.api.strategy.ComboBoxStrategy;
import br.ufsc.configurator.api.strategy.ComponentStrategy;
import br.ufsc.configurator.api.strategy.DynamicListStrategy;
import br.ufsc.configurator.api.strategy.EmbeddedStrategy;
import br.ufsc.configurator.api.strategy.GenericSuggestFieldStrategy;
import br.ufsc.configurator.api.strategy.LabelStrategy;
import br.ufsc.configurator.api.strategy.LayoutStrategy;
import br.ufsc.configurator.api.strategy.PanelStrategy;
import br.ufsc.configurator.api.strategy.RadioStrategy;
import br.ufsc.configurator.api.strategy.SubComponentStrategy;
import br.ufsc.configurator.api.strategy.SuggestFieldStrategy;
import br.ufsc.configurator.api.strategy.TableStrategy;
import br.ufsc.configurator.api.strategy.TextFieldStrategy;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("rawtypes")
public abstract class BaseConfigurableViewImpl<FORM_TYPE> implements BaseConfigurableView, FormField<FORM_TYPE> {

	protected static final Logger logger = LoggerFactory.getLogger(BaseConfigurableViewImpl.class);

	protected LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components = new LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>>();

	@Getter
	protected ViewConfigurator config;

	protected ConfiguratorBuilder builder;

	protected LayoutStrategy layoutStrategy;

	protected FieldBinder fieldBinder;

	private String viewWidth;

	@Setter
	protected boolean allInOneLine = false;

	public BaseConfigurableViewImpl() {
		this.init();
	}

	private void init() {
		this.createConfig();
		this.createBuilder();
		this.fieldBinder = this.createFieldBinder();
	}

	private LayoutStrategy createLayoutStrategy() {
		return this.config.createLayout(null);
	}

	protected FieldBinder createFieldBinder() {
		return new FieldBinder<FORM_TYPE>(this.getTypeClass());
	}

	protected void createConfig() {
		this.config = new ViewConfigurator();
	}

	protected void createBuilder() {
		this.builder = new ConfiguratorBuilder();
	}

	@Override
	public ComponentStrategy generateView(ViewConfiguration configuration, String viewWidth) {
		this.viewWidth = viewWidth;
		this.config.setViewWidth(viewWidth);
		this.createComponents(configuration);
		this.layoutStrategy = this.createLayoutStrategy();
		this.layoutStrategy.setWidth(viewWidth);
		this.render();
		return this.layoutStrategy;
	}

	private void createComponents(ViewConfiguration factories) {
		this.configView();
		this.config.setFactories(factories);
		this.components = this.builder.buildComponents(this.config);
	}

	private void render() {
		for (int line = 0; line < this.config.getTotalLines(); line++) {
			if (!this.components.get(line).isEmpty()) {
				Iterator<FormFieldConstant<?>> it = this.components.get(line).keySet().iterator();
				while (it.hasNext()) {
					FormFieldConstant<?> constant = it.next();
					ComponentStrategy<?> c = this.components.get(line).get(constant);
					ConfigField configField = this.config.getComponentConfig(constant);
					c.setWidth(CoreWidthConverter.calcWidth(configField.getOptions().width, this.viewWidth));
					if (c instanceof SubComponentStrategy) {
						this.fieldBinder.bind(constant, ((SubComponentStrategy) c).getFormField());
					} else if (c.getComponent() instanceof FormField<?>) {
						this.fieldBinder.bind(constant, (FormField) c.getComponent());
					}
					this.layoutStrategy.addComponent(c, configField.getOptions().aligment);
				}
			}
			if (line != this.config.getTotalLines() - 1 && !this.allInOneLine) {
				this.layoutStrategy.newRow();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void markInvalid(Exception e) {
		this.fieldBinder.markInvalid(null);
	}

	@Override
	public void setAlias(String alias) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setFieldValue(FORM_TYPE value) {
		if (value instanceof Collection) {
			Iterator it = ((Collection) value).iterator();
			while (it.hasNext()) {
				Object row = it.next();
				this.fieldBinder.fillIn(row);
				if (it.hasNext()) {
					this.createComponents(this.config.getFactories());
					this.render();
				}
			}
		} else {
			this.fieldBinder.fillIn(value);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public FORM_TYPE getFieldValue() {
		return (FORM_TYPE) this.fieldBinder.fillOut();
	}

	@Override
	public void clearFieldValue() {
		this.fieldBinder.clearFieldValue();
	}

	public GenericSuggestFieldStrategy<?> getGenericSuggestFieldStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getGenericSuggestFieldStrategy(componentId, this.components);
	}

	public TextFieldStrategy<?> getTextFieldStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getTextFieldStrategy(componentId, this.components);
	}

	public TableStrategy<?> getTableStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getTableStrategy(componentId, this.components);
	}

	public SubComponentStrategy<?> getSubComponentStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getSubComponentStrategy(componentId, this.components);
	}

	public ComboBoxStrategy<?> getComboBoxStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getComboBoxStrategy(componentId, this.components);
	}

	public LabelStrategy<?> getLabelStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getLabelStrategy(componentId, this.components);
	}

	public EmbeddedStrategy<?> getEmbeddedStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getEmbeddedStrategy(componentId, this.components);
	}

	public RadioStrategy<?> getRadioStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getRadioStrategy(componentId, this.components);
	}

	public CheckBoxStrategy<?> getCheckBoxStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getCheckBoxStrategy(componentId, this.components);
	}

	public PanelStrategy<?> getPanelStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getPanelStrategy(componentId, this.components);
	}

	public DynamicListStrategy<?> getDynamicListStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getDynamicListStrategy(componentId, this.components);
	}

	public SuggestFieldStrategy<?> getSuggestFieldStrategy(FormFieldConstant<?> componentId) {
		return FindStrategyHelper.getSuggestFieldStrategy(componentId, this.components);
	}

}
