package io.github.matperetti.eventschedulerapi.service.impl;

import io.github.matperetti.eventschedulerapi.domain.entity.Event;
import io.github.matperetti.eventschedulerapi.domain.entity.User;
import io.github.matperetti.eventschedulerapi.domain.repository.EventRepository;
import io.github.matperetti.eventschedulerapi.domain.repository.UserRepository;
import io.github.matperetti.eventschedulerapi.rest.dto.EventCreationDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.EventDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.EventUpdateDTO;
import io.github.matperetti.eventschedulerapi.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Override
    public EventDTO createEvent(EventCreationDTO eventCreationDTO) {
        Event event = convertToEntity(eventCreationDTO);
        Event savedEvent = eventRepository.save(event);
        return convertToDTO(savedEvent);
    }

    @Override
    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));
        return convertToDTO(event);    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO updateEvent(Long id, EventUpdateDTO eventUpdateDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));

        event.setName(eventUpdateDTO.getName());
        event.setDescription(eventUpdateDTO.getDescription());
        event.setStartTime(eventUpdateDTO.getStartTime());
        event.setEndTime(eventUpdateDTO.getEndTime());
        event.setLocation(eventUpdateDTO.getLocation());
        event.setCapacity(eventUpdateDTO.getCapacity());
        event.setStatus(eventUpdateDTO.getStatus());

        Event updatedEvent = eventRepository.save(event);
        return convertToDTO(updatedEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        dto.setStartTime(event.getStartTime());
        dto.setEndTime(event.getEndTime());
        dto.setLocation(event.getLocation());
        dto.setCapacity(event.getCapacity());
        dto.setStatus(event.getStatus());

        if (event.getUser() != null) {
            dto.setUserId(event.getUser().getId());
        }

        return dto;
    }

    private Event convertToEntity(EventCreationDTO dto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setStartTime(dto.getStartTime());
        event.setEndTime(dto.getEndTime());
        event.setLocation(dto.getLocation());
        event.setCapacity(dto.getCapacity());
        event.setStatus(dto.getStatus());

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + dto.getUserId()));
            event.setUser(user);
        }

        return event;
    }

}
