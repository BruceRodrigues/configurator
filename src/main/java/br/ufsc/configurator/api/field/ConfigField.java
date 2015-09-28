package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.ConfigOptions;
import br.ufsc.configurator.api.FormFieldConstant;
import br.ufsc.configurator.api.field.factory.BaseFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigField {

	private Integer line;

	private Integer position;

	private FormFieldConstant<?> fieldConstant;

	protected ConfigOptions options = new ConfigOptions();

	private ConfigFieldType type;

	private Integer maxLength;

	@SuppressWarnings("rawtypes")
	protected BaseFactory customFactory;

	public ConfigField(Integer line, Integer position, FormFieldConstant<?> fieldConstant, String caption, String width,
			boolean enabled, ConfigFieldType type, Integer maxLength) {
		this.line = line;
		this.position = position;
		this.fieldConstant = fieldConstant;
		this.options.caption = caption;
		this.options.width = width;
		this.options.enabled = enabled;
		this.type = type;
		this.options.maxLength = maxLength;
	}

	public ConfigField(Integer line, Integer position, FormFieldConstant<?> fieldConstant, String caption, String width,
			boolean enabled, ConfigFieldType type) {
		this(line, position, fieldConstant, caption, width, enabled, type, null);
	}

	public ConfigField(FormFieldConstant<?> fieldConstant, String caption, String width, boolean enabled,
			ConfigFieldType type) {
		this(0, -1, fieldConstant, caption, width, enabled, type);
	}

	public ConfigField(Integer line, Integer position, FormFieldConstant<?> constant, ConfigOptions options,
			ConfigFieldType type) {
		this(line, position, constant, options.caption, options.width, options.enabled, type);
	}

	public enum ConfigFieldType {
		TEXTFIELD, TABLE, COLUMN, SUBCOMPONENT, TITLE, COMBOBOX, LABEL, EMBEDDED, RADIO, CHECKBOX, PANEL, VERTICALTABSHEET, DYNAMICLIST, GENERICSUGGESTFIELD, SUGGESTFIELD;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public FormFieldConstant<?> getFieldConstant() {
		return fieldConstant;
	}

	public void setFieldConstant(FormFieldConstant<?> fieldConstant) {
		this.fieldConstant = fieldConstant;
	}

	public ConfigOptions getOptions() {
		return options;
	}

	public void setOptions(ConfigOptions options) {
		this.options = options;
	}

	public ConfigFieldType getType() {
		return type;
	}

	public void setType(ConfigFieldType type) {
		this.type = type;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public BaseFactory getCustomFactory() {
		return customFactory;
	}

	public void setCustomFactory(BaseFactory customFactory) {
		this.customFactory = customFactory;
	}
}
