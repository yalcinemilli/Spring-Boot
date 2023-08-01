package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.models.Kontakt;
import de.camovation.rauchboxapi.repository.KontaktRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class KontaktService {
    
    private final KontaktRepository kontaktRepository;

    public List<Kontakt> getKontaktById(Integer id) {
        return kontaktRepository
                .findByKundenid(id);
                
    }

    public Kontakt createKontakt(int kundenid, Kontakt kontakt) {
        kontakt.setKundenid(kundenid);
        return kontaktRepository.save(kontakt);
    }

    public Kontakt updateKontakt(int id, Kontakt kontakt) {
        Kontakt oldKontakt = kontaktRepository.findById(id);
        if (oldKontakt.getAnsprechpartner() != null) {
            oldKontakt.setAnsprechpartner(kontakt.getAnsprechpartner());
        }
        if (oldKontakt.getTelefon() != null) {
            oldKontakt.setTelefon(kontakt.getTelefon());
        }
        if (oldKontakt.getEmail() != null) {
            oldKontakt.setEmail(kontakt.getEmail());
        }

        return kontaktRepository.save(oldKontakt);
    }

    public void deleteKontaktById(int id) {
        kontaktRepository.deleteById(id);
    }

    public void deleteKontaktByKundenid(int id) {
        kontaktRepository.deleteKontaktByKundenid(id);
    }
}
