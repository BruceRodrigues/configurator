package br.ufsc.configurator.api.notifier;

import br.ufsc.configurator.api.listener.CoreClickListener;

public interface CoreClickNotifier extends CoreNotifier {

	public void addClickListener(CoreClickListener listener);

}
