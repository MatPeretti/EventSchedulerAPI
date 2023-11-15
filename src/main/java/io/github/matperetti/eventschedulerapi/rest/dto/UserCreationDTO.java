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
    @NotBlank(message = "{requiredfield.username}")
    @Size(min = 3, max = 50, message = "{invalidformat.username}")
    private String username;

    @NotBlank(message = "{requiredfield.password}")
    @Size(min = 6, message = "{invalidformat.password}")
    private String password;

    @NotBlank(message = "{requiredfield.email}")
    @Email(message = "{invalidformat.email}")
    private String email;

    @NotBlank(message = "{requiredfield.fullname}")
    private String fullName;

    @NotBlank(message= "{requiredfield.address}")
    private String address;

    @NotBlank(message = "{requiredfield.phonenumber}")
    @Pattern(regexp = "^[+]*[(]?[0-9]{1,4}[)]?[-\\s\\./0-9]*$", message = "{invalidformat.phonenumber}")
    private String phoneNumber;

    @NotBlank(message = "{requiredfield.userrole}")
    private Set<UserRole> roles;
}
