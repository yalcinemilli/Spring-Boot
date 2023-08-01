package de.camovation.rauchboxapi.service;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.models.Lieferanten;
import de.camovation.rauchboxapi.repository.LieferantenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LieferantenService {
    
    private final LieferantenRepository lieferantenRepository;

    public void deleteLieferantenById(int id) {
        lieferantenRepository.deleteById(id);
    }

    public Lieferanten createLieferanten(Lieferanten lieferanten) {
        return lieferantenRepository.save(lieferanten);
    }

    public Lieferanten updateLieferanten(int id, Lieferanten lieferanten) {
        Lieferanten oldLieferanten = lieferantenRepository.findById(id);
        if (oldLieferanten.getKundennummer() != null) {
            oldLieferanten.setKundennummer(lieferanten.getKundennummer());
        }
        if (oldLieferanten.getLieferantenname() != null) {
            oldLieferanten.setLieferantenname(lieferanten.getLieferantenname());
        }
        if (oldLieferanten.getSupporttelefon() != null) {
            oldLieferanten.setSupporttelefon(lieferanten.getSupporttelefon());
        }
        if (oldLieferanten.getAnsprechpartner() != null) {
            oldLieferanten.setAnsprechpartner(lieferanten.getAnsprechpartner());
        }

        return lieferantenRepository.save(oldLieferanten);
    }
}
