package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;
import br.ufsc.configurator.api.field.factory.GenericSuggestFieldFactory;
import lombok.Getter;

@Getter
public class ConfigGenericSuggestField extends ConfigField {

	public ConfigGenericSuggestField(Integer line, Integer position, FormFieldConstant<?> constant, String caption,
			String width, boolean enabled, GenericSuggestFieldFactory<?> customFactory, Integer maxLength) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.GENERICSUGGESTFIELD, maxLength);
		this.customFactory = customFactory;
	}

	public ConfigGenericSuggestField(Integer line, Integer position, FormFieldConstant<?> constant, String caption,
			String width, boolean enabled, GenericSuggestFieldFactory<?> customFactory) {
		this(line, position, constant, caption, width, enabled, customFactory, null);
	}
}
