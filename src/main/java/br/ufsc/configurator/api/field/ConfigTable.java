package br.ufsc.configurator.api.field;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigTable extends ConfigField {

	private Class<?> rowItemClass;

	private List<Object> items;

	public ConfigTable(Integer line, Integer position, Object fieldConstant, String caption, String width) {
		super(line, position, fieldConstant, caption, width, true, ConfigFieldType.TABLE);
	}

	public ConfigTable(Integer line, Integer position, Object fieldConstant, String caption, String width,
			Class<?> rowItemClass) {
		super(line, position, fieldConstant, caption, width, true, ConfigFieldType.TABLE);
		this.rowItemClass = rowItemClass;
	}

	public ConfigTable(Object fieldConstant, String caption, String width) {
		this(0, -1, fieldConstant, caption, width);
	}

	public ConfigTable(Object fieldConstant, String caption, String width, Class<?> rowItemClass) {
		this(0, -1, fieldConstant, caption, width, rowItemClass);
	}
}
