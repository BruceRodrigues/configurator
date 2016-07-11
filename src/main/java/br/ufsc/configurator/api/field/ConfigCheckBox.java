package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.ConfigOptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigCheckBox extends ConfigField {

	private boolean selected;

	public ConfigCheckBox(Integer line, Integer position, Object constant, String caption, String width,
			boolean enabled) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.CHECKBOX);
	}

	public ConfigCheckBox(Integer line, Integer position, Object constant, ConfigOptions options) {
		super(line, position, constant, options, ConfigFieldType.CHECKBOX);
	}
}
