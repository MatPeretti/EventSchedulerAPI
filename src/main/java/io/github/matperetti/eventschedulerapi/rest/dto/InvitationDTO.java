package io.github.matperetti.eventschedulerapi.rest.dto;

import io.github.matperetti.eventschedulerapi.domain.enums.InvitationStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class InvitationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long eventId;
    private String eventName;
    private Long userId;
    private LocalDateTime sentAt;
    private InvitationStatus status;
}
