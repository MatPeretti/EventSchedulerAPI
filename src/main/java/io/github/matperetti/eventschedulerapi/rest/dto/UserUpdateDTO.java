package io.github.matperetti.eventschedulerapi.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class UserUpdateDTO {

    @NotBlank(message = "{requiredfield.fullname}")
    private String fullName;

    @NotBlank(message = "{requiredfield.address}")
    private String address;

    @Pattern(regexp = "^[+]*[(]?[0-9]{1,4}[)]?[-\\s\\./0-9]*$", message = "{invalidformat.phonenumber}")
    private String phoneNumber;
}
