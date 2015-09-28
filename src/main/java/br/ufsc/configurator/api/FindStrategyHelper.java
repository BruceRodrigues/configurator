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

	public static ComponentStrategy<?> getComponentStrategy(FormFieldConstant<?> componentId,
			LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		Collection<LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> values = components.values();
		for (LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>> hash : values) {
			if (hash.containsKey(componentId)) {
				return hash.get(componentId);
			}
		}
		return null;
	}

	public static TextFieldStrategy<?> getTextFieldStrategy(FormFieldConstant<?> componentId,
			LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof TextFieldStrategy<?>) {
			return (TextFieldStrategy<?>) component;
		}
		return null;
	}

	public static TableStrategy<?> getTableStrategy(FormFieldConstant<?> componentId, LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof TableStrategy<?>) {
			return (TableStrategy<?>) component;
		}
		return null;
	}

	public static SubComponentStrategy<?> getSubComponentStrategy(FormFieldConstant<?> componentId,
			LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof SubComponentStrategy<?>) {
			return (SubComponentStrategy<?>) component;
		}
		return null;
	}

	public static ComboBoxStrategy<?> getComboBoxStrategy(FormFieldConstant<?> componentId,
			LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof ComboBoxStrategy<?>) {
			return (ComboBoxStrategy<?>) component;
		}
		return null;
	}

	public static LabelStrategy<?> getLabelStrategy(FormFieldConstant<?> componentId, LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof LabelStrategy<?>) {
			return (LabelStrategy<?>) component;
		}
		return null;
	}

	public static EmbeddedStrategy<?> getEmbeddedStrategy(FormFieldConstant<?> componentId,
			LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof EmbeddedStrategy<?>) {
			return (EmbeddedStrategy<?>) component;
		}
		return null;
	}

	public static RadioStrategy<?> getRadioStrategy(FormFieldConstant<?> componentId, LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof RadioStrategy<?>) {
			return (RadioStrategy<?>) component;
		}
		return null;
	}

	public static CheckBoxStrategy<?> getCheckBoxStrategy(FormFieldConstant<?> componentId,
			LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && CheckBoxStrategy.class.isAssignableFrom(component.getClass())) {
			return (CheckBoxStrategy<?>) component;
		}
		return null;
	}

	public static PanelStrategy<?> getPanelStrategy(FormFieldConstant<?> componentId, LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof PanelStrategy<?>) {
			return (PanelStrategy<?>) component;
		}
		return null;
	}

	public static DynamicListStrategy<?> getDynamicListStrategy(FormFieldConstant<?> componentId,
			LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof DynamicListStrategy<?>) {
			return (DynamicListStrategy<?>) component;
		}
		return null;
	}

	public static GenericSuggestFieldStrategy<?> getGenericSuggestFieldStrategy(FormFieldConstant<?> componentId,
			LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if (component != null && component instanceof GenericSuggestFieldStrategy<?>) {
			return (GenericSuggestFieldStrategy<?>) component;
		}
		return null;
	}

	public static SuggestFieldStrategy<?> getSuggestFieldStrategy(FormFieldConstant<?> componentId, LinkedHashMap<Integer, LinkedHashMap<FormFieldConstant<?>, ComponentStrategy<?>>> components) {
		ComponentStrategy<?> component = getComponentStrategy(componentId, components);
		if(component != null && component instanceof SuggestFieldStrategy<?>) {
			return (SuggestFieldStrategy<?>) component;
		}
		return null;
	}

}
