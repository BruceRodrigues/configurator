package br.ufsc.configurator.api.converter;

public class CoreWidthConverter {

	private static final String PERCENT = "%";

	private static final String PIXEL = "px";

	public static String calcWidth(String value, String totalView) {
		if (totalView != null) {
			if (totalView.contains(PIXEL)) {
				totalView = totalView.replace(PIXEL, "");
			}
			double total = Double.parseDouble(totalView);

			if (value != null) {
				if (value.contains(PERCENT)) {
					double percentValue = Double.parseDouble(value.replace(PERCENT, ""));
					total = (percentValue / 100) * total;
					value = total + PIXEL;
				}
			}
		}
		return value;
	}
}