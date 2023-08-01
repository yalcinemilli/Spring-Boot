package de.camovation.rauchboxapi.service;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.models.Leitstellen;
import de.camovation.rauchboxapi.repository.LeitstellenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeitstellenService {
    
    private final LeitstellenRepository leitstellenRepository;
    
    public void deleteLeitstelleById(int id) {
        leitstellenRepository.deleteById(id);
    }

    public Leitstellen createLeitstelle(Leitstellen leitstelle) {
        return leitstellenRepository.save(leitstelle);
    }

    public Leitstellen updateLeitstelle(int id, Leitstellen leitstelle) {
        Leitstellen oldLeitstelle = leitstellenRepository.findById(id);
        if (oldLeitstelle.getLeitstelle() != null) {
            oldLeitstelle.setLeitstelle(leitstelle.getLeitstelle());
        }
        if (oldLeitstelle.getKennwort() != null) {
            oldLeitstelle.setKennwort(leitstelle.getKennwort());
        }
        if (oldLeitstelle.getTelefon() != null) {
            oldLeitstelle.setTelefon(leitstelle.getTelefon());
        }

        return leitstellenRepository.save(oldLeitstelle);
    }
}