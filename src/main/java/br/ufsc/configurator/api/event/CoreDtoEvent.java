package br.ufsc.configurator.api.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoreDtoEvent<DTO> extends CoreEvent {

	private DTO value;

}
