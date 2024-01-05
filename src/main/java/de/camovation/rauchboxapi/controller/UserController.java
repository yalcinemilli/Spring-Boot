package de.camovation.rauchboxapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.camovation.rauchboxapi.mapper.UserMapper;
import de.camovation.rauchboxapi.models.User;
import de.camovation.rauchboxapi.repository.UserRepository;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.response.UserResponse;
import de.camovation.rauchboxapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<ListResponse<UserResponse>> getAllUser() {
        List<UserResponse> list = userMapper.mapToResponseListe(userRepository.findAll());
        ListResponse<UserResponse> response = new ListResponse<>(list, list.size());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<UserResponse> login(@PathVariable String email,@PathVariable String password) {

        boolean isPasswordMatch = passwordEncoder.matches(password, userRepository.findByEmail(email).getPwd());
        if (isPasswordMatch) {
            UserResponse response = userMapper.mapToResponse(userRepository.findByEmail(email));
            userService.updateTimestamp(response.getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserbyId(@PathVariable int id) {

            UserResponse response = userMapper.mapToResponse(userRepository.findById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/erstellen")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid User request) {

        if (userRepository.findByEmail(request.getEmail()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        UserResponse response = userMapper.mapToResponse(userService.createUser(request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable int id, @RequestBody @Valid User request) {
        User updatedUser = userService.updateUser(id, request);
        UserResponse response = userMapper.mapToResponse(updatedUser);
     
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/bearbeiten/updatepassword/{id}")
    public ResponseEntity<UserResponse> updatePassword(@PathVariable int id, @RequestBody @Valid User request) {
        User updatedUser = userService.updatePassword(id, request.getPwd());
        UserResponse response = userMapper.mapToResponse(updatedUser);
     
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
