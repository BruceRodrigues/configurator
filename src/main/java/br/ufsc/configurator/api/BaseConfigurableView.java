package br.ufsc.configurator.api;

import br.ufsc.configurator.api.field.ViewConfiguration;
import br.ufsc.configurator.api.strategy.ComponentStrategy;

public interface BaseConfigurableView {

	public void configView();

	public ComponentStrategy generateView(ViewConfiguration factories, String viewWidth);

}
