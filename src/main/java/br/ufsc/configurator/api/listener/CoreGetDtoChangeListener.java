package br.ufsc.configurator.api.listener;

import br.ufsc.configurator.api.event.CoreGetDtoChangeEvent;

public interface CoreGetDtoChangeListener<DTO> extends CoreListener<CoreGetDtoChangeEvent<DTO>> {

	public void onValueChangeGetDto(CoreGetDtoChangeEvent<DTO> event);

}
