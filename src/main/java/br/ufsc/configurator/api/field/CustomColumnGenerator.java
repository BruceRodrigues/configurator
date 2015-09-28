package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormFieldConstant;

public interface CustomColumnGenerator<ROW_ITEM> {

	Object generateCustomColumn(ROW_ITEM item, FormFieldConstant<?> columnId);

}
