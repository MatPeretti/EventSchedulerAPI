package io.github.matperetti.eventschedulerapi.rest.controller;

import io.github.matperetti.eventschedulerapi.rest.dto.InvitationCreationDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.InvitationDTO;
import io.github.matperetti.eventschedulerapi.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @PostMapping("/events/{eventId}/invitations")
    public ResponseEntity<InvitationDTO> sendInvitation(@PathVariable Long eventId, @RequestBody @Valid InvitationCreationDTO invitationCreationDTO) {
        invitationCreationDTO.setEventId(eventId);
        InvitationDTO invitation = invitationService.sendInvitation(invitationCreationDTO);
        return ResponseEntity.ok(invitation);
    }

    @GetMapping("/users/{userId}/invitations")
    public ResponseEntity<List<InvitationDTO>> getInvitations(@PathVariable Long userId) {
        List<InvitationDTO> invitations = invitationService.getInvitationsByUserId(userId);
        return ResponseEntity.ok(invitations);
    }
}
