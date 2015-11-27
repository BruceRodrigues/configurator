package br.ufsc.configurator.api.field;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ConfigRadio extends ConfigField {

	@Getter
	@Setter
	private List<Object> values;

	public ConfigRadio(Integer line, Integer position, Object constant, String caption, String width, boolean enabled) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.RADIO);
	}

}
