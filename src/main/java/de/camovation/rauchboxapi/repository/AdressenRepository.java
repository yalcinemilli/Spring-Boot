package de.camovation.rauchboxapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.Adresse;

public interface AdressenRepository extends JpaRepository<Adresse, Integer> {
   List<Adresse> findByKundenid(int kundenid);
   Adresse findById(int id);
   void deleteByKundenid(int id);
   void deleteAdresseByKundenid(int id);
   Optional<Adresse> findByStrasse(String strasse);
   Optional<Adresse> findByOrt(String ort);
   
}
