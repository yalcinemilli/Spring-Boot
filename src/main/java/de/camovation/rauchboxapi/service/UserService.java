package de.camovation.rauchboxapi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.models.User;
import de.camovation.rauchboxapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User mit der id: %s wurde nicht gefunden".formatted(id))
                );
    }
    public User createUser(User user) {
        user.setPwd(passwordEncoder.encode(user.getPwd()));
        return userRepository.save(user);
    }

    public void updateTimestamp(int id) {
        User user = userRepository.findById(id);
        user.setLastlogin(new java.sql.Timestamp(new java.util.Date().getTime()));
        userRepository.save(user);
    }

    public User updatePassword(int id, String password) {
        User user = userRepository.findById(id);
        user.setPwd(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
    public User updateUser(int id, User user) {
        User oldUser = userRepository.findById(id);
        if (oldUser.getVorname() != null) {
            oldUser.setVorname(user.getVorname());
        }
        if (oldUser.getNachname() != null) {
            oldUser.setNachname(user.getNachname());
        }
        if (oldUser.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        if (oldUser.getPwd() != null) {
            oldUser.setPwd(passwordEncoder.encode(user.getPwd()));
        }
        if (oldUser.getUserlevel() != user.getUserlevel()) {
            oldUser.setUserlevel(user.getUserlevel());
        }

        return userRepository.save(oldUser);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}

