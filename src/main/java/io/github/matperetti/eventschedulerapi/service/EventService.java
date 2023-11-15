package io.github.matperetti.eventschedulerapi.service;

import io.github.matperetti.eventschedulerapi.rest.dto.EventCreationDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.EventDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.EventUpdateDTO;

import java.util.List;

public interface EventService {
    EventDTO createEvent(EventCreationDTO eventCreationDTO);
    EventDTO getEventById(Long id);
    List<EventDTO> getAllEvents();
    EventDTO updateEvent(Long id, EventUpdateDTO eventUpdateDTO);
    void deleteEvent(Long id);
}
