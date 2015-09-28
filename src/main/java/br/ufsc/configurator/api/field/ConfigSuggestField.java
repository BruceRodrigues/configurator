package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;
import br.ufsc.configurator.api.field.factory.SuggestFieldFactory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigSuggestField extends ConfigField {

	private boolean selectNullAllowed = false;

	private boolean visible;

	private String itemCaptionProperty;

	public ConfigSuggestField(Integer line, Integer position, FormFieldConstant<?> constant, String caption,
			String width, boolean visible, boolean enabled, SuggestFieldFactory<?> customFactory,
			String itemCaptionProperty) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.SUGGESTFIELD);
		this.customFactory = customFactory;
		this.visible = visible;
		this.itemCaptionProperty = itemCaptionProperty;
	}
}
