package io.github.matperetti.eventschedulerapi.rest.dto;

import io.github.matperetti.eventschedulerapi.domain.enums.EventStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class EventUpdateDTO {
    @NotNull
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @Size(max = 500)
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startTime;

    @NotNull
    @FutureOrPresent
    private LocalDateTime endTime;

    @NotBlank
    private String location;

    @NotNull
    @Positive
    private Integer capacity;

    @NotNull
    private EventStatus status;
}
