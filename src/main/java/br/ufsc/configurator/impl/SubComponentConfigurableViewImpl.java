package br.ufsc.configurator.impl;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.adapter.PanelAdapter;
import br.ufsc.configurator.api.adapter.SubComponentAdapter;
import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.PanelFactory;
import br.ufsc.configurator.api.field.factory.SubComponentFactory;

public abstract class SubComponentConfigurableViewImpl<FORM_TYPE, SUBCOMPONENT_TYPE>
		extends BaseConfigurableViewImpl<FORM_TYPE>
		implements SubComponentFactory<SUBCOMPONENT_TYPE>, PanelFactory<SUBCOMPONENT_TYPE> {

	@Override
	@SuppressWarnings("unchecked")
	public ComponentAdapter<SUBCOMPONENT_TYPE> createComponent(ConfigSubComponent config) {
		SubComponentAdapter<SUBCOMPONENT_TYPE> sub = (SubComponentAdapter<SUBCOMPONENT_TYPE>) config.getConfiguration()
				.getFactory(ConfigFieldType.SUBCOMPONENT).createComponent(config);
		sub.addComponent(this.generateView(config.getConfiguration(), config.getParentWidth(), this.componentClass),
				config.getOptions().aligment);
		return sub;
	}

	@Override
	@SuppressWarnings("unchecked")
	public PanelAdapter<SUBCOMPONENT_TYPE> createPanel(ConfigSubComponent configSubComponent) {
		PanelAdapter<SUBCOMPONENT_TYPE> sub = (PanelAdapter<SUBCOMPONENT_TYPE>) ((PanelFactory<SUBCOMPONENT_TYPE>) configSubComponent
				.getConfiguration().getFactory(ConfigFieldType.PANEL)).createPanel(configSubComponent);
		sub.addComponent(this.generateView(configSubComponent.getConfiguration(), configSubComponent.getParentWidth(),
				this.componentClass), configSubComponent.getOptions().aligment);
		return sub;
	}

}
