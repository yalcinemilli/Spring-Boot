package de.camovation.rauchboxapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.Leitstellen;

public interface LeitstellenRepository extends JpaRepository<Leitstellen, Integer>{
    
    Leitstellen findById(int id);
    void deleteById(int id);
    List<Leitstellen> findByKundenid(int kundenid);
    List<Leitstellen> findByLeitstelle(String leitstelle);
}
