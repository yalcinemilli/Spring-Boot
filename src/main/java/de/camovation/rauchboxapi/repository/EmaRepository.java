package de.camovation.rauchboxapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.Ema;

public interface EmaRepository extends JpaRepository<Ema, Integer> {
    List<Ema> findByKundenid(int kundenid);
    void deleteByKundenid(int id);
    void deleteEmaByKundenid(int id);
    Ema findById(int id);
}
