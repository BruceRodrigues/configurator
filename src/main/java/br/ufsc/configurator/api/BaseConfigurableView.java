package br.ufsc.configurator.api;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ViewConfiguration;

public interface BaseConfigurableView {

	public void configView();

	public ComponentAdapter generateView(ViewConfiguration factories, String viewWidth);

}
