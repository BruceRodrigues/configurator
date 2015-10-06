package br.ufsc.configurator.api.field;

public class ConfigRadio extends ConfigField {

	public ConfigRadio(Integer line, Integer position, Object constant, String caption, String width,
			boolean enabled) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.RADIO);
	}

}
