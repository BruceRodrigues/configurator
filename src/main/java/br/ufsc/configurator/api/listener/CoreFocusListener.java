package br.ufsc.configurator.api.listener;

import br.ufsc.configurator.api.event.CoreFocusEvent;

public interface CoreFocusListener extends CoreListener<CoreFocusEvent> {

	public void onFocus(CoreFocusEvent event);

}
