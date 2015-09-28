package br.ufsc.configurator.api.strategy;

import br.ufsc.configurator.api.FormField;

public interface SubComponentStrategy<COMPONENT_TYPE> extends LayoutStrategy<COMPONENT_TYPE> {

	FormField getFormField();

}
