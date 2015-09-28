package br.ufsc.configurator.api;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = "description")
@ToString(of = "description")
public class FormFieldConstant<TYPE> implements Serializable {

	private static final long serialVersionUID = -5538971991966205918L;

	private Class<TYPE> type;
	private String description;

	public FormFieldConstant(Class<TYPE> type, String description) {
		this.type = type;
		this.description = description;
	}

	public Class<TYPE> getType() {
		return this.type;
	}

	public String getDescription() {
		return this.description;
	}

}
