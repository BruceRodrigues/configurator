package br.ufsc.configurator.api.listener;

import br.ufsc.configurator.api.event.CoreClickEvent;

public interface CoreClickListener extends CoreListener<CoreClickEvent> {

	public void onClick(CoreClickEvent event);

}
