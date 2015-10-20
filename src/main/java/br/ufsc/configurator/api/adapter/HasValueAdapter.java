package br.ufsc.configurator.api.adapter;

public interface HasValueAdapter<COMPONENT_TYPE> extends ComponentAdapter<COMPONENT_TYPE> {

	public void setValue(Object value);

	public Object getValue();

}
