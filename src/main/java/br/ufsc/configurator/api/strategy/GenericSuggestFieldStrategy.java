package br.ufsc.configurator.api.strategy;

public interface GenericSuggestFieldStrategy<COMPONENT_TYPE> extends ComponentStrategy<COMPONENT_TYPE> {

	void setValue(Object value);

}
