package io.github.matperetti.eventschedulerapi.rest.controller;

import io.github.matperetti.eventschedulerapi.rest.dto.UserCreationDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.UserDTO;
import io.github.matperetti.eventschedulerapi.rest.dto.UserUpdateDTO;
import io.github.matperetti.eventschedulerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreationDTO userCreationDTO){
        UserDTO newUser = userService.createUser(userCreationDTO);
        return  new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> user = userService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity <UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO userUpdateDTO){
        userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
