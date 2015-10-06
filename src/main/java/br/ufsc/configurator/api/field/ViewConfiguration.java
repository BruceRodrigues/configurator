package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.factory.BaseFactory;
import br.ufsc.configurator.api.field.factory.LayoutFactory;

@SuppressWarnings("rawtypes")
public interface ViewConfiguration {

	BaseFactory getFactory(ConfigFieldType type);

	LayoutFactory<?> getLayoutFactory();

	BaseFactory getCustomFactory(Object factoryId);

	void addCustomFactory(Object factoryId, BaseFactory factory);
}
