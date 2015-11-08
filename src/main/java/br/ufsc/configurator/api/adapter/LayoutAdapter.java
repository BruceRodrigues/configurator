package br.ufsc.configurator.api.adapter;

import java.util.List;

import br.ufsc.configurator.api.ConfigOptions;

public interface LayoutAdapter<LAYOUT_TYPE> extends ComponentAdapter<LAYOUT_TYPE> {

	void addComponent(ComponentAdapter<?> component, ConfigOptions.Alignment alignment);

	void newRow();

	void setRowWidth(String value);

	List<ComponentAdapter<?>> getComponents();

}
