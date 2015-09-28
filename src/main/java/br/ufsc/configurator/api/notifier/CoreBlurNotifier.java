package br.ufsc.configurator.api.notifier;

import br.ufsc.configurator.api.listener.CoreBlurListener;

public interface CoreBlurNotifier<DTO> extends CoreNotifier {

	public void addBlurListener(CoreBlurListener<DTO> listener);

}
