package br.ufsc.configurator.api.builder;

import java.util.LinkedHashMap;
import java.util.List;

import br.ufsc.configurator.api.ViewConfigurator;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.TableAdapter;
import br.ufsc.configurator.api.converter.CoreWidthConverter;
import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.PanelFactory;
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

public class ConfiguratorBuilder {

	public LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> buildComponents(ViewConfigurator config) {

		LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components = new LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>>();

		for (Integer line = 0; line < config.getTotalLines(); line++) {
			LinkedHashMap<Object, ComponentAdapter<?>> fields = new LinkedHashMap<Object, ComponentAdapter<?>>();
			List<ConfigField> inputs = config.getComponents(line);
			for (ConfigField configField : inputs) {
				Object formField = configField.getFieldConstant();
				ComponentAdapter<?> componentField = this.createComponent(configField, config);
				fields.put(formField, componentField);
				this.addListener(componentField, formField, config);

			}
			components.put(line, fields);
		}
		return components;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ComponentAdapter<?> createComponent(ConfigField configField, ViewConfigurator config) {
		if (configField.getCustomFactory() != null) {
			return configField.getCustomFactory().createComponent(configField);
		}

		ComponentAdapter<?> componentField = config.getFactories().getFactory(configField.getType())
				.createComponent(configField);
		switch (configField.getType()) {
		case TABLE:
			((TableAdapter) componentField).createColumns(config.getColumns(configField.getFieldConstant()));
			break;
		case PANEL:
		case SUBCOMPONENT:
			ConfigSubComponent panelConfig = (ConfigSubComponent) configField;
			panelConfig.setConfiguration(config.getFactories());
			panelConfig.setParentWidth(
					CoreWidthConverter.calcWidth(configField.getOptions().width, config.getViewWidth()));
			if (ConfigFieldType.PANEL.equals(configField.getType())) {
				return ((PanelFactory) panelConfig.getFormField()).createPanel(panelConfig);
			} else {
				return panelConfig.getFormField().createComponent(panelConfig);
			}
		default:
			break;
		}
		return componentField;
	}

	@SuppressWarnings("unchecked")
	private void addListener(ComponentAdapter<?> component, Object id, ViewConfigurator config) {
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