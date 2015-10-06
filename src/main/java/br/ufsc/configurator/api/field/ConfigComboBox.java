package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.field.factory.ComboBoxFactory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigComboBox extends ConfigField {

	private boolean selectNullAllowed = false;

	private boolean visible;

	private String itemCaptionProperty;

	public ConfigComboBox(Integer line, Integer position, Object constant, String caption, String width,
			boolean visible, boolean enabled, ComboBoxFactory<?> customFactory, String itemCaptionProperty) {
		super(line, position, constant, caption, width, enabled, ConfigFieldType.COMBOBOX);
		this.customFactory = customFactory;
		this.visible = visible;
		this.itemCaptionProperty = itemCaptionProperty;
	}

}
