package br.ufsc.configurator.api.adapter;

import java.util.List;

import br.ufsc.configurator.api.field.ConfigColumn;

public interface TableAdapter<COMPONENT_TYPE> extends HasValueAdapter<COMPONENT_TYPE> {

	void createColumns(List<ConfigColumn> columns);

	void addColumn(Object constant, ConfigColumn columnConfig);

	void setColumWidth(Object constant, String width);

}
