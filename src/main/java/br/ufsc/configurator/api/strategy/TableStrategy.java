package br.ufsc.configurator.api.strategy;

import java.util.List;

import br.ufsc.configurator.api.FormFieldConstant;
import br.ufsc.configurator.api.field.ConfigColumn;

public interface TableStrategy<COMPONENT_TYPE> extends ComponentStrategy<COMPONENT_TYPE> {

	void createColumns(List<ConfigColumn> columns);

	void addColumn(FormFieldConstant<?> constant, ConfigColumn columnConfig);

	void setColumWidth(FormFieldConstant<?> constant, String width);

}
