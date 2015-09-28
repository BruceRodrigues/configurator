package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.factory.BaseFactory;
import br.ufsc.configurator.api.field.factory.LayoutFactory;

public interface ViewConfiguration {

	@SuppressWarnings("rawtypes")
	BaseFactory getFactory(ConfigFieldType type);

	LayoutFactory<?> getLayoutFactory();
}
