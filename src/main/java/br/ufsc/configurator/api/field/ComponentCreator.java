package br.ufsc.configurator.api.field;

import br.ufsc.configurator.api.FormField;

public interface ComponentCreator<FORM> {

	FormField<FORM> createComponent(FORM form);

}
