package br.ufsc.configurator.api.strategy;

public interface ComboBoxStrategy<COMPONENT_TYPE> extends ComponentStrategy<COMPONENT_TYPE> {

	Object getValue();

	void setValue(Object value);

	void setForceReload(boolean forceReload);

}
