package de.camovation.rauchboxapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.Wartung;

public interface WartungRepository extends JpaRepository<Wartung, Integer> {
    
    Wartung findById(int id);
    void deleteById(int id);
    void deleteWartungByKundenid(int id);
    List<Wartung> findByKundenid(int kundenid);
}
