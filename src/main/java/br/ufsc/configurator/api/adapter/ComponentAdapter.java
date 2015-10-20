package br.ufsc.configurator.api.adapter;

public interface ComponentAdapter<COMPONENT_TYPE> {

	void setWidth(String width);

	void setEnabled(boolean value);

	void setVisible(boolean value);

	COMPONENT_TYPE getComponent();

	String getCaption();

}
