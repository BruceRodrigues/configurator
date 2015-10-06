package br.ufsc.configurator.api.field;

public interface CustomColumnGenerator<ROW_ITEM> {

	Object generateCustomColumn(ROW_ITEM item, Object columnId);

}
