package de.camovation.rauchboxapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.User;


public interface UserRepository extends JpaRepository<User, Integer>{

    User findById(int id);
    User findByEmail(String email);
}
