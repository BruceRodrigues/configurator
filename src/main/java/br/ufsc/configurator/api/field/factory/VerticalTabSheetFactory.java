package br.ufsc.configurator.api.field.factory;

import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.strategy.VerticalTabSheetStrategy;

public interface VerticalTabSheetFactory<COMPONENT_TYPE> extends BaseFactory<COMPONENT_TYPE, ConfigSubComponent> {

	VerticalTabSheetStrategy<COMPONENT_TYPE> createVerticalTabSheet(ConfigSubComponent config);

}
