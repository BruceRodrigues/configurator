package br.ufsc.configurator.api.utils;

public class StringUtils {

	public static boolean isBlank(String value) {
		return (value == null || value.isEmpty());
	}

	public static String capitalize(String string) {
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}

}
