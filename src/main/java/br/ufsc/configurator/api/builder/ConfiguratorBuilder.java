package br.ufsc.configurator.api.builder;

import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufsc.configurator.api.ViewConfigurator;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.ViewConfiguration;
import br.ufsc.configurator.api.field.factory.PanelFactory;
import br.ufsc.configurator.api.field.factory.VerticalTabSheetFactory;
import br.ufsc.configurator.api.listener.CoreBlurListener;
import br.ufsc.configurator.api.listener.CoreClickListener;
import br.ufsc.configurator.api.listener.CoreFocusListener;
import br.ufsc.configurator.api.listener.CoreGetDtoChangeListener;
import br.ufsc.configurator.api.listener.CoreShortCutListener;
import br.ufsc.configurator.api.listener.CoreValueChangeListener;
import br.ufsc.configurator.api.notifier.CoreBlurNotifier;
import br.ufsc.configurator.api.notifier.CoreClickNotifier;
import br.ufsc.configurator.api.notifier.CoreFocusNotifier;
import br.ufsc.configurator.api.notifier.CoreGetDtoChangeNotifier;
import br.ufsc.configurator.api.notifier.CoreShortCutNotifier;
import br.ufsc.configurator.api.notifier.CoreValueChangeNotifier;
import br.ufsc.configurator.api.strategy.ComponentStrategy;
import br.ufsc.configurator.api.strategy.TableStrategy;

public class ConfiguratorBuilder {

	protected static final Logger logger = LoggerFactory.getLogger(ConfiguratorBuilder.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> buildComponents(
			ViewConfigurator config) {

		LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components = new LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>>();

		ViewConfiguration factories = config.getFactories();

		for (Integer line = 0; line < config.getTotalLines(); line++) {
			LinkedHashMap<Object, ComponentStrategy<?>> fields = new LinkedHashMap<Object, ComponentStrategy<?>>();
			List<ConfigField> inputs = config.getComponents(line);
			for (ConfigField configField : inputs) {
				Object formField = configField.getFieldConstant();
				try {
					ComponentStrategy<?> componentField = null;
					if (configField.getCustomFactory() != null) {
						componentField = configField.getCustomFactory().createComponent(configField);
					} else {
						componentField = factories.getFactory(configField.getType()).createComponent(configField);
						switch (configField.getType()) {
						case TABLE:
							((TableStrategy) componentField).createColumns(config.getColumns(formField));
							break;
						case PANEL:
						case SUBCOMPONENT:
							ConfigSubComponent panelConfig = (ConfigSubComponent) configField;
							panelConfig.setConfiguration(config.getFactories());
							panelConfig.setParentWidth(config.getViewWidth());
							if (ConfigFieldType.PANEL.equals(configField.getType())) {
								componentField = ((PanelFactory) panelConfig.getFormField()).createPanel(panelConfig);
							} else if (ConfigFieldType.SUBCOMPONENT.equals(configField.getType())) {
								componentField = panelConfig.getFormField().createComponent(panelConfig);
							} else {
								componentField = ((VerticalTabSheetFactory) panelConfig.getFormField())
										.createVerticalTabSheet(panelConfig);
							}
							break;
						default:
							break;
						}
					}
					fields.put(formField, componentField);
					this.addListener(componentField, formField, config);
				} catch (Exception e) {
					logger.error("Erro na criação de fields", e);
				}
			}
			components.put(line, fields);
		}
		return components;
	}

	@SuppressWarnings("unchecked")
	private void addListener(ComponentStrategy<?> component, Object id, ViewConfigurator config) {
		List<CoreBlurListener<?>> blurListeners = config.getBlurListener(id);
		if (blurListeners != null) {
			for (@SuppressWarnings("rawtypes")
			CoreBlurListener listener : blurListeners) {
				((CoreBlurNotifier<?>) component).addBlurListener(listener);
			}
		}
		List<CoreClickListener> clickListeners = config.getClickListener(id);
		if (clickListeners != null) {
			for (CoreClickListener listener : clickListeners) {
				((CoreClickNotifier) component).addClickListener(listener);
			}
		}
		List<CoreFocusListener> focusListeners = config.getFocusListener(id);
		if (focusListeners != null) {
			for (CoreFocusListener listener : focusListeners) {
				((CoreFocusNotifier) component).addFocusListener(listener);
			}
		}
		List<CoreShortCutListener> shortCutListeners = config.getShortCutListener(id);
		if (shortCutListeners != null) {
			for (CoreShortCutListener listener : shortCutListeners) {
				((CoreShortCutNotifier) component).addShortCutListener(listener);
			}
		}
		List<CoreValueChangeListener> valueListeners = config.getValueChangeListener(id);
		if (valueListeners != null) {
			for (CoreValueChangeListener listener : valueListeners) {
				((CoreValueChangeNotifier) component).addValueChangeListener(listener);
			}
		}
		List<CoreGetDtoChangeListener<?>> getDtoListeners = config.getGetDtoChangeListener(id);
		if (getDtoListeners != null) {
			for (@SuppressWarnings("rawtypes")
			CoreGetDtoChangeListener listener : getDtoListeners) {
				((CoreGetDtoChangeNotifier<?>) component).addGetDtoChangeListener(listener);
			}
		}

	}
}