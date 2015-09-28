package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;

public class ConfigRadio extends ConfigField {

	public ConfigRadio(Integer line, Integer position, FormFieldConstant<?> constant, String caption, String width,
			boolean enabled) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.RADIO);
	}

}
