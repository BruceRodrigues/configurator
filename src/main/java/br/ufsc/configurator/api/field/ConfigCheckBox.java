package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.FormFieldConstant;

public class ConfigCheckBox extends ConfigField {

	public ConfigCheckBox(Integer line, Integer position, FormFieldConstant<?> constant, String caption, String width,
			boolean enabled) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.CHECKBOX);
	}

	public ConfigCheckBox(Integer line, Integer position, FormFieldConstant<?> constant, ConfigOptions options) {
		super(line, position, constant, options, ConfigFieldType.CHECKBOX);
	}
}
