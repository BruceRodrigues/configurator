package br.ufsc.configurator.api.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoreValueChangeEvent extends CoreEvent {

	private Object value;

}
