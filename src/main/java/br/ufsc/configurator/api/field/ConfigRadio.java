package br.ufsc.configurator.api.field;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigRadio extends ConfigField {

	private List<Object> values;

	private Object selectedValue;

	public ConfigRadio(Integer line, Integer position, Object constant, String caption, String width, boolean enabled) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.RADIO);
	}

	public ConfigRadio(Object id, String caption, String width, boolean enabled) {
		this(-1, -1, id, caption, width, enabled);
	}

}
