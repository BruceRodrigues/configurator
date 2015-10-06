package br.ufsc.configurator.api;

import java.util.Collection;
import java.util.LinkedHashMap;

import br.ufsc.configurator.api.strategy.CheckBoxStrategy;
import br.ufsc.configurator.api.strategy.ComboBoxStrategy;
import br.ufsc.configurator.api.strategy.ComponentStrategy;
import br.ufsc.configurator.api.strategy.DynamicListStrategy;
import br.ufsc.configurator.api.strategy.EmbeddedStrategy;
import br.ufsc.configurator.api.strategy.GenericSuggestFieldStrategy;
import br.ufsc.configurator.api.strategy.LabelStrategy;
import br.ufsc.configurator.api.strategy.PanelStrategy;
import br.ufsc.configurator.api.strategy.RadioStrategy;
import br.ufsc.configurator.api.strategy.SubComponentStrategy;
import br.ufsc.configurator.api.strategy.SuggestFieldStrategy;
import br.ufsc.configurator.api.strategy.TableStrategy;
import br.ufsc.configurator.api.strategy.TextFieldStrategy;

public class FindStrategyHelper {

	public static ComponentStrategy<?> getComponentStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		Collection<LinkedHashMap<Object, ComponentStrategy<?>>> values = components.values();
		for (LinkedHashMap<Object, ComponentStrategy<?>> hash : values) {
			if (hash.containsKey(componentId)) {
				return hash.get(componentId);
			}
		}
		return null;
	}

	public static TextFieldStrategy<?> getTextFieldStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof TextFieldStrategy<?>) {
			return (TextFieldStrategy<?>) component;
		}
		return null;
	}

	public static TableStrategy<?> getTableStrategy(Object componentId, LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof TableStrategy<?>) {
			return (TableStrategy<?>) component;
		}
		return null;
	}

	public static SubComponentStrategy<?> getSubComponentStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof SubComponentStrategy<?>) {
			return (SubComponentStrategy<?>) component;
		}
		return null;
	}

	public static ComboBoxStrategy<?> getComboBoxStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof ComboBoxStrategy<?>) {
			return (ComboBoxStrategy<?>) component;
		}
		return null;
	}

	public static LabelStrategy<?> getLabelStrategy(Object componentId, LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof LabelStrategy<?>) {
			return (LabelStrategy<?>) component;
		}
		return null;
	}

	public static EmbeddedStrategy<?> getEmbeddedStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof EmbeddedStrategy<?>) {
			return (EmbeddedStrategy<?>) component;
		}
		return null;
	}

	public static RadioStrategy<?> getRadioStrategy(Object componentId, LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof RadioStrategy<?>) {
			return (RadioStrategy<?>) component;
		}
		return null;
	}

	public static CheckBoxStrategy<?> getCheckBoxStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && CheckBoxStrategy.class.isAssignableFrom(component.getClass())) {
			return (CheckBoxStrategy<?>) component;
		}
		return null;
	}

	public static PanelStrategy<?> getPanelStrategy(Object componentId, LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof PanelStrategy<?>) {
			return (PanelStrategy<?>) component;
		}
		return null;
	}

	public static DynamicListStrategy<?> getDynamicListStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof DynamicListStrategy<?>) {
			return (DynamicListStrategy<?>) component;
		}
		return null;
	}

	public static GenericSuggestFieldStrategy<?> getGenericSuggestFieldStrategy(Object componentId,
			LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof GenericSuggestFieldStrategy<?>) {
			return (GenericSuggestFieldStrategy<?>) component;
		}
		return null;
	}

	public static SuggestFieldStrategy<?> getSuggestFieldStrategy(Object componentId, LinkedHashMap<Integer, LinkedHashMap<Object, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if(component != null && component instanceof SuggestFieldStrategy<?>) {
			return (SuggestFieldStrategy<?>) component;
		}
		return null;
	}

}
