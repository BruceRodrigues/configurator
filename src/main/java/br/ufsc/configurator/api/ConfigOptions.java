package br.ufsc.configurator.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigOptions {

	public String caption;

	public String width;

	public Alignment aligment;

	public boolean enabled;

	public String style;

	public Integer maxLength;

	public enum Alignment {
		RIGHT,
		CENTER,
		LEFT;
	}

}
