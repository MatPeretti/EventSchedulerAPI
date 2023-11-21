package io.github.matperetti.eventschedulerapi.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InvitationCreationDTO {

    @NotNull(message = "{requiredfield.eventId}")
    private Long eventId;

    @NotNull(message = "{requiredfield.invitedUserId}")
    private Long invitedUserId;
}
