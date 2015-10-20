package br.ufsc.configurator.api;

import java.util.Collection;
import java.util.LinkedHashMap;

import br.ufsc.configurator.api.adapter.CheckBoxAdapter;
import br.ufsc.configurator.api.adapter.ComboBoxAdapter;
import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.EmbeddedAdapter;
import br.ufsc.configurator.api.adapter.LabelAdapter;
import br.ufsc.configurator.api.adapter.PanelAdapter;
import br.ufsc.configurator.api.adapter.RadioAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.adapter.TableAdapter;
import br.ufsc.configurator.api.adapter.TextFieldAdapter;

public class FindStrategyHelper {

	public static ComponentAdapter<?> getComponentStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		Collection<LinkedHashMap<Object, ComponentAdapter<?>>> values = components.values();
		for (LinkedHashMap<Object, ComponentAdapter<?>> hash : values) {
			if (hash.containsKey(componentId)) {
				return hash.get(componentId);
			}
		}
		return null;
	}

	public static TextFieldAdapter<?> getTextFieldStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof TextFieldAdapter<?>) {
			return (TextFieldAdapter<?>) component;
		}
		return null;
	}

	public static TableAdapter<?> getTableStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof TableAdapter<?>) {
			return (TableAdapter<?>) component;
		}
		return null;
	}

	public static SubComponentAdapter<?> getSubComponentStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof SubComponentAdapter<?>) {
			return (SubComponentAdapter<?>) component;
		}
		return null;
	}

	public static ComboBoxAdapter<?> getComboBoxStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof ComboBoxAdapter<?>) {
			return (ComboBoxAdapter<?>) component;
		}
		return null;
	}

	public static LabelAdapter<?> getLabelStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof LabelAdapter<?>) {
			return (LabelAdapter<?>) component;
		}
		return null;
	}

	public static EmbeddedAdapter<?> getEmbeddedStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof EmbeddedAdapter<?>) {
			return (EmbeddedAdapter<?>) component;
		}
		return null;
	}

	public static RadioAdapter<?> getRadioStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof RadioAdapter<?>) {
			return (RadioAdapter<?>) component;
		}
		return null;
	}

	public static CheckBoxAdapter<?> getCheckBoxStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && CheckBoxAdapter.class.isAssignableFrom(component.getClass())) {
			return (CheckBoxAdapter<?>) component;
		}
		return null;
	}

	public static PanelAdapter<?> getPanelStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentAdapter<?>>> components) {
		ComponentAdapter<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof PanelAdapter<?>) {
			return (PanelAdapter<?>) component;
		}
		return null;
	}

}
