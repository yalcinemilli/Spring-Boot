package de.camovation.rauchboxapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.CustomField;

public interface CustomFieldRepository extends JpaRepository<CustomField, Integer>{

    CustomField findById(int id);
    List<CustomField> findByObjectid(String objectid);
    void deleteById(int id);
}
