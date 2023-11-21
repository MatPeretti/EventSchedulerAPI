package io.github.matperetti.eventschedulerapi.service.impl;

// Importações...

import io.github.matperetti.eventschedulerapi.domain.entity.Event;
import io.github.matperetti.eventschedulerapi.domain.entity.Invitation;
import io.github.matperetti.eventschedulerapi.domain.entity.User;
import io.github.matperetti.eventschedulerapi.domain.enums.InvitationStatus;
import io.github.matperetti.eventschedulerapi.domain.repository.EventRepository;
import io.github.matperetti.eventschedulerapi.domain.repository.InvitationRepository;
import io.github.matperetti.eventschedulerapi.domain.repository.UserRepository;
import io.github.matperetti.eventschedulerapi.rest.dto.InvitationCreationDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.InvitationDTO;
import io.github.matperetti.eventschedulerapi.service.InvitationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final InvitationRepository invitationRepository;

    @Override
    public InvitationDTO sendInvitation(InvitationCreationDTO invitationCreationDTO) {
        Invitation invitation = convertToEntity(invitationCreationDTO);
        Invitation savedInvitation = invitationRepository.save(invitation);
        return convertToDTO(savedInvitation);
    }


    @Override
    public List<InvitationDTO> getInvitationsByUserId(Long userId) {
        List<Invitation> invitations = invitationRepository.findByInvitedUserId(userId);
        return invitations.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private InvitationDTO convertToDTO(Invitation invitation) {
        InvitationDTO dto = new InvitationDTO();

        dto.setId(invitation.getId());
        dto.setEventId(invitation.getEvent().getId());
        dto.setUserId(invitation.getInvitedUser().getId());
        dto.setSentAt(invitation.getSentAt());
        dto.setStatus(invitation.getStatus());
        dto.setEventName(invitation.getEvent().getName());

        return dto;
    }

    private Invitation convertToEntity(InvitationCreationDTO dto) {
        Invitation invitation = new Invitation();

        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id: " + dto.getEventId()));
        User invitedUser = userRepository.findById(dto.getInvitedUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + dto.getInvitedUserId()));

        invitation.setEvent(event);
        invitation.setInvitedUser(invitedUser);
        invitation.setSentAt(LocalDateTime.now());
        invitation.setStatus(InvitationStatus.PENDING);

        return invitation;
    }
}
