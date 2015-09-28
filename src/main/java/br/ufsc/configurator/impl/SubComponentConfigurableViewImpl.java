package br.ufsc.configurator.impl;

import br.ufsc.configurator.api.field.ConfigField.ConfigFieldType;
import br.ufsc.configurator.api.field.ConfigSubComponent;
import br.ufsc.configurator.api.field.factory.PanelFactory;
import br.ufsc.configurator.api.field.factory.SubComponentFactory;
import br.ufsc.configurator.api.field.factory.VerticalTabSheetFactory;
import br.ufsc.configurator.api.strategy.ComponentStrategy;
import br.ufsc.configurator.api.strategy.PanelStrategy;
import br.ufsc.configurator.api.strategy.SubComponentStrategy;
import br.ufsc.configurator.api.strategy.VerticalTabSheetStrategy;

public abstract class SubComponentConfigurableViewImpl<FORM_TYPE, SUBCOMPONENT_TYPE>
		extends BaseConfigurableViewImpl<FORM_TYPE>implements SubComponentFactory<SUBCOMPONENT_TYPE>,
		PanelFactory<SUBCOMPONENT_TYPE>, VerticalTabSheetFactory<SUBCOMPONENT_TYPE> {

	@Override
	@SuppressWarnings("unchecked")
	public ComponentStrategy<SUBCOMPONENT_TYPE> createComponent(ConfigSubComponent config) {
		SubComponentStrategy<SUBCOMPONENT_TYPE> sub = (SubComponentStrategy<SUBCOMPONENT_TYPE>) config
				.getConfiguration().getFactory(ConfigFieldType.SUBCOMPONENT).createComponent(config);
		sub.addComponent(this.generateView(config.getConfiguration(), config.getParentWidth()),
				config.getOptions().aligment);
		return sub;
	}

	@Override
	@SuppressWarnings("unchecked")
	public PanelStrategy<SUBCOMPONENT_TYPE> createPanel(ConfigSubComponent configSubComponent) {
		PanelStrategy<SUBCOMPONENT_TYPE> sub = (PanelStrategy<SUBCOMPONENT_TYPE>) ((PanelFactory<SUBCOMPONENT_TYPE>) configSubComponent
				.getConfiguration().getFactory(ConfigFieldType.PANEL)).createPanel(configSubComponent);
		sub.addComponent(this.generateView(configSubComponent.getConfiguration(), configSubComponent.getParentWidth()),
				configSubComponent.getOptions().aligment);
		return sub;
	}

	@Override
	@SuppressWarnings("unchecked")
	public VerticalTabSheetStrategy<SUBCOMPONENT_TYPE> createVerticalTabSheet(ConfigSubComponent config) {
		VerticalTabSheetStrategy<SUBCOMPONENT_TYPE> sub = (((VerticalTabSheetFactory<SUBCOMPONENT_TYPE>) config
				.getConfiguration().getFactory(ConfigFieldType.VERTICALTABSHEET)).createVerticalTabSheet(config));
		sub.addComponent(this.generateView(config.getConfiguration(), config.getParentWidth()),
				config.getOptions().aligment);
		return sub;
	}

}
