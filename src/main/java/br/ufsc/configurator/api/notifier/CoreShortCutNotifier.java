package br.ufsc.configurator.api.notifier;

import br.ufsc.configurator.api.listener.CoreShortCutListener;

public interface CoreShortCutNotifier extends CoreNotifier {

	public void addShortCutListener(CoreShortCutListener listener);

}
