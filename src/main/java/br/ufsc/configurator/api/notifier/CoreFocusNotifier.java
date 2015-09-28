package br.ufsc.configurator.api.notifier;

import br.ufsc.configurator.api.listener.CoreFocusListener;

public interface CoreFocusNotifier extends CoreNotifier {

	public void addFocusListener(CoreFocusListener listener);

}
