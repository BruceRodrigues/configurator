package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;
import lombok.Getter;

@Getter
public class ConfigTextField extends ConfigField {

	private boolean visible;

	public ConfigTextField(Integer line, Integer position, FormFieldConstant<?> fieldConstant, String caption,
			String width, boolean visible, boolean enabled, Integer maxLength) {
		super(line, position, fieldConstant, caption, width, enabled, ConfigFieldType.TEXTFIELD, maxLength);
		this.visible = visible;
	}

}
