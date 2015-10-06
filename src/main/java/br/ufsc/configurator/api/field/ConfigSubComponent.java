package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.field.factory.SubComponentFactory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigSubComponent extends ConfigField {

	private SubComponentFactory formField;

	private ViewConfiguration configuration;

	private String parentWidth;

	public ConfigSubComponent(Integer line, Integer position, Object fieldConstant, String caption,
			String width, SubComponentFactory formField) {
		super(line, position, fieldConstant, caption, width, true, ConfigFieldType.SUBCOMPONENT);
		this.formField = formField;
	}

	public ConfigSubComponent(Integer line, Integer position, Object fieldConstant, String caption,
			String width, SubComponentFactory formField, ConfigFieldType type) {
		super(line, position, fieldConstant, caption, width, true, type);
		this.formField = formField;
	}

	public SubComponentFactory getFormField() {
		return formField;
	}

	public void setFormField(SubComponentFactory formField) {
		this.formField = formField;
	}

	public ViewConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ViewConfiguration configuration) {
		this.configuration = configuration;
	}

	public String getParentWidth() {
		return parentWidth;
	}

	public void setParentWidth(String parentWidth) {
		this.parentWidth = parentWidth;
	}

}
