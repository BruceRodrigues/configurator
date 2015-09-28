package br.ufsc.configurator.api.strategy;

import java.util.List;

import br.ufsc.configurator.api.ConfigOptions;

public interface LayoutStrategy<LAYOUT_TYPE> extends ComponentStrategy<LAYOUT_TYPE> {

	void addComponent(ComponentStrategy<?> component, ConfigOptions.Alignment alignment);

	void newRow();

	List<ComponentStrategy<?>> getComponents();

}
