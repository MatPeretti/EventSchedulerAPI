package io.github.matperetti.eventschedulerapi.rest.dto;

import io.github.matperetti.eventschedulerapi.domain.enums.EventStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EventCreationDTO {
    @NotBlank(message = "{requiredfield.eventname}")
    @Size(max = 100, message = "{invalidformat.eventname}")
    private String name;

    @NotNull(message = "{requiredfield.description}")
    @Size(max = 500, message = "{invalidformat.description}")
    private String description;

    @NotNull(message = "{requiredfield.starttime}")
    @FutureOrPresent(message = "{invalidformat.starttime}")
    private LocalDateTime startTime;

    @NotNull(message = "{requiredfield.endtime}")
    @FutureOrPresent(message = "{invalidformat.endtime}")
    private LocalDateTime endTime;

    @NotBlank(message = "{requiredfield.location}")
    private String location;

    @NotNull(message = "{requiredfield.capacity}")
    @Positive(message = "{invalidformat.capacity}")
    private Integer capacity;

    @NotNull(message = "{requiredfield.status}")
    private EventStatus status;

    @NotNull(message = "{requiredfield.userid}")
    private Long userId;
}
