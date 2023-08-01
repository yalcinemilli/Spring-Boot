package de.camovation.rauchboxapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.Kontakt;

public interface KontaktRepository extends JpaRepository<Kontakt, Integer>{
    List<Kontakt> findByKundenid(int kundenid);
    Kontakt findById(int id);
    void deleteByKundenid(int id);
    void deleteKontaktByKundenid(int id);
}
