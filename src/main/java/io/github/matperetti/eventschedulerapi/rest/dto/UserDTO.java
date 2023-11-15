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
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Boolean isActive;
    private Boolean isVerified;
    private Set<UserRole> roles;
}
