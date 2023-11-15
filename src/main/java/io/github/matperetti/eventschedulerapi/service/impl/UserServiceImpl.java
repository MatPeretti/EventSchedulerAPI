package io.github.matperetti.eventschedulerapi.service.impl;

import io.github.matperetti.eventschedulerapi.domain.entity.User;
import io.github.matperetti.eventschedulerapi.domain.repository.UserRepository;
import io.github.matperetti.eventschedulerapi.rest.dto.UserCreationDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.UserDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.UserUpdateDTO;
import io.github.matperetti.eventschedulerapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserCreationDTO userCreationDTO) {
        User user = new User();
        user.setUsername(userCreationDTO.getUsername());
        user.setPassword((userCreationDTO.getPassword()));
        user.setEmail(userCreationDTO.getEmail());
        user.setFullName(userCreationDTO.getFullName());
        user.setAddress(userCreationDTO.getAddress());
        user.setPhoneNumber(userCreationDTO.getPhoneNumber());
        user.setRoles(userCreationDTO.getRoles());
        user.setIsActive(true);
        user.setIsVerified(false);

        User savedUser = userRepository.save(user);

        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        return convertToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        updateUserData(user, userUpdateDTO);

        User updatedUser = userRepository.save(user);

        return convertToDTO(updatedUser);
    }

    private void updateUserData(User user, UserUpdateDTO userUpdateDTO) {
        user.setFullName(userUpdateDTO.getFullName());
        user.setAddress(userUpdateDTO.getAddress());
        user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setAddress(user.getAddress());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setIsActive(user.getIsActive());
        dto.setIsVerified(user.getIsVerified());
        dto.setRoles(user.getRoles());
        return dto;
    }
}

