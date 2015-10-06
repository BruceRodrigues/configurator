package br.ufsc.configurator.api.strategy;

public interface SubComponentStrategy<COMPONENT_TYPE> extends LayoutStrategy<COMPONENT_TYPE> {

	Object getFormField();

}
