package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;

public class ConfigEmbedded extends ConfigField {

	public ConfigEmbedded(Integer line, Integer position, FormFieldConstant<?> fieldConstant, String caption,
			String width) {
		super(line, position, fieldConstant, caption, width, true, ConfigFieldType.EMBEDDED);
	}

}
