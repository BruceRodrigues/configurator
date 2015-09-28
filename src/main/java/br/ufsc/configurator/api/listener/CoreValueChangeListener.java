package br.ufsc.configurator.api.listener;

import br.ufsc.configurator.api.event.CoreValueChangeEvent;

public interface CoreValueChangeListener extends CoreListener<CoreValueChangeEvent> {

	public void onValueChange(CoreValueChangeEvent event);

}
