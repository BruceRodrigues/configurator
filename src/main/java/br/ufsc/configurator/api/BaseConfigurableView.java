package br.ufsc.configurator.api;

import br.ufsc.configurator.api.adapter.ComponentAdapter;
import br.ufsc.configurator.api.field.ViewConfiguration;

public interface BaseConfigurableView {

	public void configView();

	<COMPONENT_TYPE> ComponentAdapter<COMPONENT_TYPE> generateView(ViewConfiguration factories, String viewWidth,
			Class<COMPONENT_TYPE> componentClass);

}
