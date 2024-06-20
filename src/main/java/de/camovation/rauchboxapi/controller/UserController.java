package de.camovation.rauchboxapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import de.camovation.rauchboxapi.service.mfa.MFATokenManager;
import dev.samstevens.totp.exceptions.QrGenerationException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MFATokenManager mfaTokenManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<ListResponse<UserResponse>> getAllUser() {
        List<UserResponse> list = userMapper.mapToResponseListe(userRepository.findAll());
        ListResponse<UserResponse> response = new ListResponse<>(list, list.size());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

        @GetMapping("/login/{email}/{password}")
    public ResponseEntity<?> login(@PathVariable String email,@PathVariable String password) {
        UserResponse response = userMapper.mapToResponse(userRepository.findByEmail(email));
        if (response == null) {
            return new ResponseEntity<>("E-Mail Adresse nicht gefunden!", HttpStatus.UNAUTHORIZED);
        }
        boolean isPasswordMatch = passwordEncoder.matches(password, userRepository.findByEmail(email).getPwd());
        if (isPasswordMatch) {
            userService.updateTimestamp(response.getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Passwort ist falsch", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/login/{email}/{password}/{code}")
    public ResponseEntity<?> loginwith2FA(@PathVariable String email,@PathVariable String password, @PathVariable String code) {
        UserResponse response = userMapper.mapToResponse(userRepository.findByEmail(email));
        if (response == null) {
            return new ResponseEntity<>("E-Mail Adresse nicht gefunden!", HttpStatus.UNAUTHORIZED);
        }
        boolean isPasswordMatch = passwordEncoder.matches(password, userRepository.findByEmail(email).getPwd());
        if (isPasswordMatch) {
            if (response.getIs2fa() == 1) {
                if (mfaTokenManager.verifyTotp(code, response.getSecretcode())){
                    userService.updateTimestamp(response.getId());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            } else {
            return new ResponseEntity<>("Passwort ist falsch", HttpStatus.UNAUTHORIZED);
            }
        }

    @GetMapping("/login/qrcode")
    public ResponseEntity<Map<String, String>> getQRAndSecretCode() throws QrGenerationException {
        Map<String, String> map = new HashMap<>();
        String secret = mfaTokenManager.generateSecretKey();
        String qrCode = mfaTokenManager.getQRCode(secret);
        map.put("secret", secret);
        map.put("qrCode", qrCode);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/login/verify/{secret}/{code}")
    public ResponseEntity<Boolean> verifyCode(@PathVariable String secret, @PathVariable String code) {
        boolean isCodeValid = mfaTokenManager.verifyTotp(code, secret);
        return new ResponseEntity<>(isCodeValid, HttpStatus.OK);
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