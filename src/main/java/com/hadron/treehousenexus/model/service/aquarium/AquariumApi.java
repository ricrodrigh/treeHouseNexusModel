package com.hadron.treehousenexus.model.service.aquarium;

import java.util.Collection;

public interface AquariumApi<ResponseType> {
	
	/**
	 * URL /homeEvents/loadEvents
	 * @param input
	 * @return
	 */
	public ResponseType loadEvent(LoadEventsQuery input);
	public Collection<ResponseType> loadAllEvents();
}
