package io.github.matperetti.eventschedulerapi.rest.dto;

import io.github.matperetti.eventschedulerapi.domain.enums.InvitationStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvitationDTO {
    private Long id;
    private Long eventId;
    private String eventName;
    private Long userId;
    private LocalDateTime sentAt;
    private InvitationStatus status;
}
