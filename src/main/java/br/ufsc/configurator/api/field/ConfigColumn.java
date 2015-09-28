package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigColumn extends ConfigField {

	private FormFieldConstant<?> tableConstant;

	private CustomColumnGenerator customColumnGenerator;

	public ConfigColumn(Integer position, FormFieldConstant<?> fieldConstant, FormFieldConstant<?> tableConstant,
			String caption, String width) {
		super(0, position, fieldConstant, caption, width, true, ConfigFieldType.COLUMN);
		this.tableConstant = tableConstant;
	}

	public ConfigColumn(Integer position, FormFieldConstant<?> fieldConstant, FormFieldConstant<?> tableConstant,
			String caption, String width, CustomColumnGenerator customColumnGenerator) {
		super(0, position, fieldConstant, caption, width, true, ConfigFieldType.COLUMN);
		this.tableConstant = tableConstant;
		this.customColumnGenerator = customColumnGenerator;
	}

	public boolean hasCustomColumnGenerator() {
		return this.customColumnGenerator != null;
	}

	public FormFieldConstant<?> getTableConstant() {
		return tableConstant;
	}

	public void setTableConstant(FormFieldConstant<?> tableConstant) {
		this.tableConstant = tableConstant;
	}

	public CustomColumnGenerator getCustomColumnGenerator() {
		return customColumnGenerator;
	}

	public void setCustomColumnGenerator(CustomColumnGenerator customColumnGenerator) {
		this.customColumnGenerator = customColumnGenerator;
	}

}
