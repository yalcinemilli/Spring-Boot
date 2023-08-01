package de.camovation.rauchboxapi.service;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.models.UserLevel;
import de.camovation.rauchboxapi.repository.UserLevelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserLevelService {
    
    private final UserLevelRepository userLevelRepository;

    public UserLevel getUserLevelById(Integer id) {
        return userLevelRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("UserLevel mit der id: %s wurde nicht gefunden".formatted(id))
                );
    }

    public UserLevel createUserLevel(UserLevel userLevel) {
        return userLevelRepository.save(userLevel);
    }

    public void deleteUserLevel(int id) {
        userLevelRepository.deleteById(id);
    }

    public UserLevel updateUserLevel(int id, UserLevel userLevel) {
        UserLevel oldUserLevel = userLevelRepository.findById(id);
        if (oldUserLevel.getId() != userLevel.getId()) {
            oldUserLevel.setId(userLevel.getId());
        }
        if (oldUserLevel.getLevelname() != null) {
            oldUserLevel.setLevelname(userLevel.getLevelname());
        }
        return userLevelRepository.save(oldUserLevel);
    }
}
