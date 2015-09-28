package br.ufsc.configurator.api.strategy;

public interface ComponentStrategy<COMPONENT_TYPE> {

	void setWidth(String width);

	void setEnabled(boolean value);

	COMPONENT_TYPE getComponent();

	String getCaption();

}
