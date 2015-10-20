package br.ufsc.configurator.api.adapter;

public interface SubComponentAdapter<COMPONENT_TYPE> extends LayoutAdapter<COMPONENT_TYPE> {

	Object getFormField();

}
