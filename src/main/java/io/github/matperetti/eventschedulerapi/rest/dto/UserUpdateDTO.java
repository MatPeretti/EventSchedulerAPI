package io.github.matperetti.eventschedulerapi.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class UserUpdateDTO {
    @NotBlank(message = "Full name is required")
    private String fullName;

    private String address;

    @Pattern(regexp = "^[+]*[(]?[0-9]{1,4}[)]?[-\\s\\./0-9]*$", message = "Invalid phone number")
    private String phoneNumber;
}
