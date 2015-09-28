package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigMaskedField extends ConfigField {

	private String mask;

	public ConfigMaskedField(FormFieldConstant<?> fieldConstant, String caption, String width, boolean enabled,
			ConfigFieldType type) {
		super(fieldConstant, caption, width, enabled, type);
	}

}
