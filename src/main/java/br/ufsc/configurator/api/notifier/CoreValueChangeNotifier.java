package br.ufsc.configurator.api.notifier;

import br.ufsc.configurator.api.listener.CoreValueChangeListener;

public interface CoreValueChangeNotifier extends CoreNotifier {

	void addValueChangeListener(CoreValueChangeListener listener);

}
