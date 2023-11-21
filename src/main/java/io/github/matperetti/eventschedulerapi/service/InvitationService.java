package io.github.matperetti.eventschedulerapi.service;

import io.github.matperetti.eventschedulerapi.rest.dto.InvitationCreationDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.InvitationDTO;

import java.util.List;

public interface InvitationService {
    InvitationDTO sendInvitation(InvitationCreationDTO invitationCreationDTO);
    List<InvitationDTO> getInvitationsByUserId(Long userId);
}
