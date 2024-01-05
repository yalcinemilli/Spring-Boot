package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.mapper.KontaktMapper;
import de.camovation.rauchboxapi.models.Kontakt;
import de.camovation.rauchboxapi.repository.KontaktRepository;
import de.camovation.rauchboxapi.response.KontaktResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class KontaktService {
    
    private final KontaktRepository kontaktRepository;
    private final KontaktMapper kontaktMapper;
    public List<Kontakt> getKontaktById(Integer id) {
        return kontaktRepository
                .findByKundenid(id);
                
    }

    public List<KontaktResponse> getKontakt (Integer id) {
        List<Kontakt> kontakt = kontaktRepository.findByKundenid(id);
        List<KontaktResponse> list = kontaktMapper.mapToResponseListe(kontakt);
        return list;
    }

    public Kontakt createKontakt(int kundenid, Kontakt kontakt) {
        kontakt.setKundenid(kundenid);
        return kontaktRepository.save(kontakt);
    }

    public Kontakt updateKontakt(int id, Kontakt kontakt) {
        Kontakt oldKontakt = kontaktRepository.findById(id);
        if (kontakt.getAnsprechpartner() != null) {
            oldKontakt.setAnsprechpartner(kontakt.getAnsprechpartner());
        }
        if (kontakt.getTelefon() != null) {
            oldKontakt.setTelefon(kontakt.getTelefon());
        }
        if (kontakt.getEmail() != null) {
            oldKontakt.setEmail(kontakt.getEmail());
        }
        if (kontakt.getNotizen() != null) {
            oldKontakt.setNotizen(kontakt.getNotizen());
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
