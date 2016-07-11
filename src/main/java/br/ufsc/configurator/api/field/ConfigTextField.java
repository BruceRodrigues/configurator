package br.ufsc.configurator.api.field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigTextField extends ConfigField {

	private boolean visible;

	private String value;

	public ConfigTextField(Integer line, Integer position, Object fieldConstant, String caption, String width,
			boolean visible, boolean enabled, Integer maxLength) {
		super(line, position, fieldConstant, caption, width, enabled, ConfigFieldType.TEXTFIELD, maxLength);
		this.visible = visible;
	}

}
