package de.camovation.rauchboxapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.camovation.rauchboxapi.mapper.UserLevelMapper;
import de.camovation.rauchboxapi.models.UserLevel;
import de.camovation.rauchboxapi.repository.UserLevelRepository;
import de.camovation.rauchboxapi.response.UserLevelResponse;
import de.camovation.rauchboxapi.service.UserLevelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/userlevel")
public class UserLevelController {
    
    private final UserLevelRepository userLevelRepository;
    private final UserLevelMapper userLevelMapper;
    private final UserLevelService userLevelService;
    
    @GetMapping
    public List<UserLevel> getAllUser() {
        return userLevelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLevelResponse> getUserLevelById(@PathVariable int id) {
        UserLevel userLevel = userLevelService.getUserLevelById(id);
        UserLevelResponse response = userLevelMapper.mapToResponse(userLevel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/erstellen")
    public ResponseEntity<UserLevelResponse> createUserLevel(@RequestBody @Valid UserLevel request) {
        UserLevel createdUserLevel = userLevelService.createUserLevel(request);
        UserLevelResponse response = userLevelMapper.mapToResponse(createdUserLevel);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<UserLevelResponse> updateUserLevel(@PathVariable int id, @RequestBody @Valid UserLevel request) {
        UserLevel updatedUserLevel = userLevelService.updateUserLevel(id, request);
        UserLevelResponse response = userLevelMapper.mapToResponse(updatedUserLevel);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteUserLevel(@PathVariable int id) {
        userLevelService.deleteUserLevel(id);
    
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
