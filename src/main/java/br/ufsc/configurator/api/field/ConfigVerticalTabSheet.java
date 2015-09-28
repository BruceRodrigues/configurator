package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;

public class ConfigVerticalTabSheet extends ConfigField {

	public ConfigVerticalTabSheet(FormFieldConstant<?> fieldConstant, String caption, String width, boolean enabled,
			ConfigFieldType type) {
		super(fieldConstant, caption, width, enabled, type);
	}

}
