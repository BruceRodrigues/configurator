package br.ufsc.configurator.api.strategy;

public interface SuggestFieldStrategy<COMPONENT_TYPE> extends ComponentStrategy<COMPONENT_TYPE> {

	void setValue(Object value);

}
