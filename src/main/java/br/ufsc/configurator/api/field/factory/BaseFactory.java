package br.ufsc.configurator.api.field.factory;

import br.ufsc.configurator.api.field.ConfigField;
import br.ufsc.configurator.api.strategy.ComponentStrategy;

public interface BaseFactory<COMPONENT_TYPE, CONFIG extends ConfigField> {

	ComponentStrategy<COMPONENT_TYPE> createComponent(CONFIG config);

}
