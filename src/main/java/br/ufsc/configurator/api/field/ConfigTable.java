package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigTable extends ConfigField {

	private Class<?> rowItemClass;

	public ConfigTable(Integer line, Integer position, FormFieldConstant<?> fieldConstant, String caption,
			String width) {
		super(line, position, fieldConstant, caption, width, true, ConfigFieldType.TABLE);
	}

	public ConfigTable(Integer line, Integer position, FormFieldConstant<?> fieldConstant, String caption, String width,
			Class<?> rowItemClass) {
		super(line, position, fieldConstant, caption, width, true, ConfigFieldType.TABLE);
		this.rowItemClass = rowItemClass;
	}

	public ConfigTable(FormFieldConstant<?> fieldConstant, String caption, String width) {
		this(0, -1, fieldConstant, caption, width);
	}

	public ConfigTable(FormFieldConstant<?> fieldConstant, String caption, String width, Class<?> rowItemClass) {
		this(0, -1, fieldConstant, caption, width, rowItemClass);
	}
}
