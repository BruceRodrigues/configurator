package br.ufsc.configurator.api;

public interface TypedComboValueChangeListener<DTO> {

	void onTypedComboValueChange(DTO value, boolean forceRefresh);

}
