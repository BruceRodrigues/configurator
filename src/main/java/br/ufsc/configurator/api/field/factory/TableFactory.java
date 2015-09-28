package br.ufsc.configurator.api.field.factory;

import java.util.List;

import br.ufsc.configurator.api.field.ConfigColumn;
import br.ufsc.configurator.api.field.ConfigTable;

public interface TableFactory<TABLE_TYPE> extends BaseFactory<TABLE_TYPE, ConfigTable> {

	void createColumns(List<ConfigColumn> columns);

}
