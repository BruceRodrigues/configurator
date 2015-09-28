package br.ufsc.configurator.api.notifier;

import br.ufsc.configurator.api.listener.CoreGetDtoChangeListener;

public interface CoreGetDtoChangeNotifier<DTO> extends CoreNotifier {

	void addGetDtoChangeListener(CoreGetDtoChangeListener<DTO> listener);

}
