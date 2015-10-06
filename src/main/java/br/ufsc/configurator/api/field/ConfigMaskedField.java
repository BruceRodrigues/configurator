package br.ufsc.configurator.api.field;

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

	public ConfigMaskedField(Object fieldConstant, String caption, String width, boolean enabled,
			ConfigFieldType type) {
		super(fieldConstant, caption, width, enabled, type);
	}

}
