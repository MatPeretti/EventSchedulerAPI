package io.github.matperetti.eventschedulerapi.service;

import io.github.matperetti.eventschedulerapi.rest.dto.UserCreationDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.UserDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserCreationDTO userCreationDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);
    void deleteUser(Long id);
}
