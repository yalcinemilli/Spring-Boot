package de.camovation.rauchboxapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.UserLevel;


public interface UserLevelRepository extends JpaRepository<UserLevel, Integer>{
    UserLevel findById(int id);
}
