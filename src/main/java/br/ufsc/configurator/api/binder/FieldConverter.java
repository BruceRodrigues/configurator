package br.ufsc.configurator.api.binder;

public interface FieldConverter<ATTRIBUTE_TYPE, VIEW_TYPE> {

	Class<ATTRIBUTE_TYPE> getAttributeType();

	ATTRIBUTE_TYPE convertToAttributeType(VIEW_TYPE value);

	VIEW_TYPE convertToViewType(ATTRIBUTE_TYPE value);

}
