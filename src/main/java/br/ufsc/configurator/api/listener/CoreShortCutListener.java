package br.ufsc.configurator.api.listener;

import br.ufsc.configurator.api.event.CoreShortCutEvent;

public interface CoreShortCutListener extends CoreListener<CoreShortCutEvent> {

	public void onShortCut(CoreShortCutEvent event);

}
