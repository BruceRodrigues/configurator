package br.ufsc.configurator.api.field.factory;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ConfigField;

public interface BaseFactory<COMPONENT_TYPE, CONFIG extends ConfigField> {

	ComponentAdapter<COMPONENT_TYPE> createComponent(CONFIG config);

}
