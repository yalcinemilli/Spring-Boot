package de.camovation.rauchboxapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.Lieferanten;

public interface LieferantenRepository extends JpaRepository<Lieferanten, Integer>{
    
    Lieferanten findById(int id);
    void deleteById(int id);
    Lieferanten findByKundennummer(String kundennummer);
}
