package br.ufsc.configurator.api.adapter;

public interface ComboBoxAdapter<COMPONENT_TYPE> extends HasValueAdapter<COMPONENT_TYPE> {

	void setForceReload(boolean forceReload);

}
