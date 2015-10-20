package br.ufsc.configurator.api.field.factory;

import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.field.ConfigSubComponent;

public interface PanelFactory<COMPONENT_TYPE> extends SubComponentFactory<COMPONENT_TYPE> {

	SubComponentAdapter<COMPONENT_TYPE> createPanel(ConfigSubComponent configSubComponent);

}
