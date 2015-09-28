package br.ufsc.configurator.api.field.factory;

import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.strategy.SubComponentStrategy;

public interface PanelFactory<COMPONENT_TYPE> extends SubComponentFactory<COMPONENT_TYPE> {

	SubComponentStrategy<COMPONENT_TYPE> createPanel(ConfigSubComponent configSubComponent);

}
