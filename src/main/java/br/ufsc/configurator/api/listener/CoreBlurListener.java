package br.ufsc.configurator.api.listener;

import br.ufsc.configurator.api.event.CoreBlurEvent;

public interface CoreBlurListener<DTO> extends CoreListener<CoreBlurEvent<DTO>> {

	public void onBlur(CoreBlurEvent<DTO> event);

}
