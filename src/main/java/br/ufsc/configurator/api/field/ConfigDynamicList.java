package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;
import br.ufsc.configurator.api.field.factory.DynamicListFactory;
import lombok.Getter;

@Getter
public class ConfigDynamicList extends ConfigField {

	public ConfigDynamicList(Integer line, Integer position, FormFieldConstant<?> constant, String caption,
			String width, DynamicListFactory<?> customFactory) {
		super(line, position, constant, caption, width, true, ConfigFieldType.DYNAMICLIST);
		this.customFactory = customFactory;
	}

}
