package br.ufsc.configurator.api;

public interface FormField<TYPE> {

	public TYPE getFieldValue();

	public void setFieldValue(TYPE value);

	public void clearFieldValue();

	public Class<TYPE> getTypeClass();

	public void setAlias(String alias);

	public void markInvalid(Exception e);

}
