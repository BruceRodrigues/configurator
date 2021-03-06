package br.ufsc.configurator.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;

import br.ufsc.configurator.api.BaseConfigurableView;
import br.ufsc.configurator.api.FindStrategyHelper;
import br.ufsc.configurator.api.ViewConfigurator;
import br.ufsc.configurator.api.adapter.CheckBoxAdapter;
import br.ufsc.configurator.api.adapter.ComboBoxAdapter;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.EmbeddedAdapter;
import br.ufsc.configurator.api.adapter.HasValueAdapter;
import br.ufsc.configurator.api.adapter.LabelAdapter;
import br.ufsc.configurator.api.adapter.LayoutAdapter;
import br.ufsc.configurator.api.adapter.PanelAdapter;
import br.ufsc.configurator.api.adapter.RadioAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.adapter.TableAdapter;
import br.ufsc.configurator.api.adapter.TextFieldAdapter;
import br.ufsc.configurator.api.builder.ConfiguratorBuilder;
import br.ufsc.configurator.api.converter.CoreWidthConverter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.ViewConfiguration;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("rawtypes")
public abstract class BaseConfigurableViewImpl implements BaseConfigurableView {

	@Getter
	protected LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components = new LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>>();

	@Getter
	protected ViewConfigurator config;

	protected ConfiguratorBuilder builder;

	protected LayoutAdapter layoutAdapter;

	private String viewWidth;

	@Setter
	protected boolean allInOneLine = false;

	public BaseConfigurableViewImpl() {
		this.init();
	}

	private void init() {
		this.createConfig();
		this.createBuilder();
	}

	private <COMPONENT_TYPE> LayoutAdapter<COMPONENT_TYPE> createLayoutAdapter() {
		return this.config.createLayout(null);
	}

	protected void createConfig() {
		this.config = new ViewConfigurator();
	}

	protected void createBuilder() {
		this.builder = new ConfiguratorBuilder();
	}

	@Override
	public <COMPONENT_TYPE> ComponentAdapter<COMPONENT_TYPE> generateView(ViewConfiguration configuration,
			String viewWidth, Class<COMPONENT_TYPE> componentClass) {
		this.viewWidth = viewWidth;
		this.createConfig();
		this.config.setViewWidth(viewWidth);
		this.config.setFactories(configuration);
		this.layoutAdapter = this.createLayoutAdapter();
		this.createComponents(configuration);
		this.layoutAdapter.setWidth(viewWidth);
		this.render();
		return this.layoutAdapter;
	}

	private void createComponents(ViewConfiguration factories) {
		this.configView();
		this.components = this.builder.buildComponents(this.config);
	}

	@SuppressWarnings("unchecked")
	private void render() {
		for (int line = 0; line < this.config.getTotalLines(); line++) {
			if (!this.components.get(line).isEmpty()) {
				Iterator<Object> it = this.components.get(line).keySet().iterator();
				while (it.hasNext()) {
					Object constant = it.next();
					ComponentAdapter<?> c = this.components.get(line).get(constant);
					ConfigField configField = this.config.getComponentConfig(constant);
					c.setWidth(CoreWidthConverter.calcWidth(configField.getOptions().width, this.viewWidth));
					this.layoutAdapter.addComponent(c, configField.getOptions().aligment);
				}
			}
			if (line != this.config.getTotalLines() - 1 && !this.allInOneLine) {
				this.layoutAdapter.newRow();
			}
		}
	}

	public void setFieldValue(Object componentId, Object value) {
		ComponentAdapter<?> adapter = FindStrategyHelper.getComponentStrategy(componentId, this.components);
		if (adapter != null && adapter instanceof HasValueAdapter<?>) {
			((HasValueAdapter<?>) adapter).setValue(value);
		}
	}

	public Object getFieldValue(Object id) {
		ComponentAdapter<?> adapter = FindStrategyHelper.getComponentStrategy(id, this.components);
		if (adapter != null && adapter instanceof HasValueAdapter<?>) {
			return ((HasValueAdapter<?>) adapter).getValue();
		}
		return null;
	}

	public TextFieldAdapter<?> getTextFieldStrategy(Object componentId) {
		return FindStrategyHelper.getTextFieldStrategy(componentId, this.components);
	}

	public TableAdapter<?> getTableStrategy(Object componentId) {
		return FindStrategyHelper.getTableStrategy(componentId, this.components);
	}

	public SubComponentAdapter<?> getSubComponentStrategy(Object componentId) {
		return FindStrategyHelper.getSubComponentStrategy(componentId, this.components);
	}

	public ComboBoxAdapter<?> getComboBoxStrategy(Object componentId) {
		return FindStrategyHelper.getComboBoxStrategy(componentId, this.components);
	}

	public LabelAdapter<?> getLabelStrategy(Object componentId) {
		return FindStrategyHelper.getLabelStrategy(componentId, this.components);
	}

	public EmbeddedAdapter<?> getEmbeddedStrategy(Object componentId) {
		return FindStrategyHelper.getEmbeddedStrategy(componentId, this.components);
	}

	public RadioAdapter<?> getRadioStrategy(Object componentId) {
		return FindStrategyHelper.getRadioStrategy(componentId, this.components);
	}

	public CheckBoxAdapter<?> getCheckBoxStrategy(Object componentId) {
		return FindStrategyHelper.getCheckBoxStrategy(componentId, this.components);
	}

	public PanelAdapter<?> getPanelStrategy(Object componentId) {
		return FindStrategyHelper.getPanelStrategy(componentId, this.components);
	}

	protected String calcWidth(String percent) {
		return CoreWidthConverter.calcWidth(percent, this.viewWidth);
	}

}
