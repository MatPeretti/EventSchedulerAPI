package io.github.matperetti.eventschedulerapi.rest.dto;

import io.github.matperetti.eventschedulerapi.domain.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserCreationDTO {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "{invalidformat.username}")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "{invalidformat.password}")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Full name is required")
    private String fullName;

    private String address;

    @Pattern(regexp = "^[+]*[(]?[0-9]{1,4}[)]?[-\\s\\./0-9]*$", message = "Invalid phone number")
    private String phoneNumber;

    private Set<UserRole> roles;
}
