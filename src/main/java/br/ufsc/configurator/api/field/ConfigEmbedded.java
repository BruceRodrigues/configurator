package br.ufsc.configurator.api.field;

public class ConfigEmbedded extends ConfigField {

	public ConfigEmbedded(Integer line, Integer position, Object fieldConstant, String caption,
			String width) {
		super(line, position, fieldConstant, caption, width, true, ConfigFieldType.EMBEDDED);
	}

}
