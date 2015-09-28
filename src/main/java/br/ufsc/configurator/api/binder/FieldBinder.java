package br.ufsc.configurator.api.binder;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufsc.configurator.api.FormField;
import br.ufsc.configurator.api.FormFieldConstant;
import br.ufsc.configurator.api.utils.StringUtils;

/**
 * Classe responsável por armazenar os {@link FormField} disponíveis na tela.
 * Cada {@link FormField} é associado a um atributo do Form, dessa forma a
 * classe é capaz de realizar o FillIn e o FillOut automaticamente através de
 * reflection. Ao adicionar um {@link FormField} na tela utilizar os
 * construtores disponíveis nessa classe passando o string da propriedade como
 * parâmetro ou utilizar o método {@link #bind(String, FormField)}.
 *
 * @author Gabriel
 *
 * @param <FORM>
 */

@SuppressWarnings("rawtypes")
public class FieldBinder<FORM> {

	private static final Logger logger = LoggerFactory.getLogger(FieldBinder.class);
	private final HashMap<String, FormField> properties;
	private final HashMap<String, FieldConverter> converters;
	private FormField<FORM> resend;
	private final Class<FORM> formClass;
	private String aliasPrefix;

	public FieldBinder(Class<FORM> formClass) {
		this.formClass = formClass;
		this.properties = new LinkedHashMap<String, FormField>();
		this.converters = new HashMap<String, FieldConverter>();
		this.aliasPrefix = formClass.getSimpleName();
		this.resend = null;
	}

	public FieldBinder(Class<FORM> formClass, String aliasPrefix) {
		this(formClass);
		if (!StringUtils.isBlank(aliasPrefix)) {
			this.aliasPrefix = aliasPrefix;
		}
	}

	/**
	 * Adiciona um {@link FormField} ao Hash e o associa à propriedade passada
	 * como parâmetro.
	 *
	 * @param key
	 * @param field
	 */
	public <TYPE> void bind(FormFieldConstant<TYPE> key, FormField<TYPE> field) {
		this.properties.put(key.getDescription(), field);
		this.setAlias(key, field);
	}

	public void resend(FormField<FORM> formField) {
		this.resend = formField;
	}

	/**
	 * Adiciona um {@link FormField} ao Hash e o associa à propriedade passada
	 * como parâmetro. Além disso associa um {@link FieldConverter} à essa
	 * propriedade, que fará a conversão dos dados de um tipo para outro.
	 *
	 * @param key
	 * @param field
	 * @param converter
	 */
	public <ATTRIBUTE_TYPE, FIELD_TYPE> void bind(FormFieldConstant<ATTRIBUTE_TYPE> key, FormField<FIELD_TYPE> field,
			FieldConverter<ATTRIBUTE_TYPE, FIELD_TYPE> converter) {
		this.properties.put(key.getDescription(), field);
		this.converters.put(key.getDescription(), converter);
		this.setAlias(key, field);
	}

	public <ATTRIBUTE_TYPE, FIELD_TYPE> void setConverter(FormFieldConstant<ATTRIBUTE_TYPE> key,
			FieldConverter<ATTRIBUTE_TYPE, FIELD_TYPE> converter) {
		this.converters.put(key.getDescription(), converter);
	}

	private void setAlias(FormFieldConstant<?> key, FormField<?> field) {
		field.setAlias(this.aliasPrefix + "." + key.getDescription());
	}

	public FormField get(FormFieldConstant key) {
		return this.properties.get(key.getDescription());
	}

	public FormField get(String key) {
		return this.properties.get(key);
	}

	public List<String> getProperties() {
		return new ArrayList<String>(this.properties.keySet());
	}

	@SuppressWarnings("unchecked")
	public FORM fillOut() {
		FORM form = null;
		if (this.resend != null) {
			form = this.resend.getFieldValue();
		} else {
			try {
				form = this.formClass.getConstructor().newInstance();
			} catch (Exception e) {
				FieldBinder.logger.error("Erro no FillOut - ", e);
			}
		}
		for (String key : this.properties.keySet()) {
			try {
				Method declaredMethod = this.getSetter(key);
				Object fieldValue = this.get(key).getFieldValue();
				if (this.converters.containsKey(key)) {
					declaredMethod.invoke(form, this.converters.get(key).convertToAttributeType(fieldValue));
				} else {
					declaredMethod.invoke(form, fieldValue);
				}
			} catch (Exception e) {
				FieldBinder.logger.error("Erro no FillOut - " + key, e);
			}
		}
		return form;

	}

	@SuppressWarnings("unchecked")
	public void fillIn(FORM form) {
		if (this.resend != null) {
			this.resend.setFieldValue(form);
		}
		for (String field : this.properties.keySet()) {
			FormField input = this.properties.get(field);
			try {
				Object attributeValue = this.getGetter(field).invoke(form);
				if (this.converters.containsKey(field)) {
					input.setFieldValue(this.converters.get(field).convertToViewType(attributeValue));
				} else {
					input.setFieldValue(attributeValue);
				}
			} catch (Exception e) {
				FieldBinder.logger.error("Erro no FillIn - " + field, e);
			}
		}
	}

	public void clearFieldValue() {
		for (String key : this.properties.keySet()) {
			FormField field = this.get(key);
			if (field != null) {
				field.clearFieldValue();

			}
		}
	}

	public void clearAllInvalid() {
		for (String key : this.properties.keySet()) {
			try {
				FormField field = this.get(key);
				if (field != null) {
					field.markInvalid(null);
				}
			} catch (Exception e) {
				FieldBinder.logger.error("Erro no FillOut - " + key, e);
			}
		}
	}

	public void markInvalid(Map<String, Exception> errors) {
		this.clearAllInvalid();
		if (errors != null) {
			for (String key : errors.keySet()) {
				FormField field = this.get(key);
				if (field != null) {
					Exception e = errors.get(key);
					field.markInvalid(e);
				}
			}
		}
	}

	private Method getSetter(String property) throws SecurityException, NoSuchMethodException {
		Class typeClass;
		if (this.converters.containsKey(property)) {
			typeClass = this.converters.get(property).getAttributeType();
		} else {
			typeClass = this.get(property).getTypeClass();
		}
		return this.formClass.getMethod("set" + StringUtils.capitalize(property), typeClass);
	}

	private Method getGetter(String property) throws SecurityException, NoSuchMethodException {
		return this.formClass.getMethod("get" + StringUtils.capitalize(property));
	}

	public <TYPE> void stash(FormFieldConstant<TYPE> key) {
		this.bind(key, new StashField<TYPE>(key.getType()));
	}

}