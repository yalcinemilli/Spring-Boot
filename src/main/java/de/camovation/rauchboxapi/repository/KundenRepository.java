package de.camovation.rauchboxapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.camovation.rauchboxapi.models.Kunde;



public interface KundenRepository extends JpaRepository<Kunde, String>{
     Optional<Kunde> findByKundenname(String kundenname);
     Optional<Kunde> findById(int id);
     Optional<Kunde> findByIdentnummer(String identnummer);
     void deleteById(int id);
}
