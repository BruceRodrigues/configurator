package br.ufsc.configurator.api.strategy;

public interface TextFieldStrategy<COMPONENT_TYPE> extends ComponentStrategy<COMPONENT_TYPE> {

	public void setValue(String value);

}
