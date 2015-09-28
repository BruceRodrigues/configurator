package br.ufsc.configurator.api.binder;

import br.ufsc.configurator.api.FormField;

public class StashField<TYPE> implements FormField<TYPE> {

	private Class<TYPE> type;
	private TYPE value;

	public StashField(Class<TYPE> type) {
		super();
		this.type = type;
	}

	public TYPE getFieldValue() {
		return value;
	}

	public void setFieldValue(TYPE value) {
		this.value = value;
	}

	public void clearFieldValue() {
		this.value = null;
	}

	public Class<TYPE> getTypeClass() {
		return this.type;
	}

	public void setAlias(String alias) {
	}

	public void markInvalid(Exception e) {
	}

}