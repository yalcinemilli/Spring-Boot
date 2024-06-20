package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.mapper.AdressenMapper;
import de.camovation.rauchboxapi.models.Adresse;
import de.camovation.rauchboxapi.repository.AdressenRepository;
import de.camovation.rauchboxapi.response.AdresseResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdressenService {
    
    private final AdressenRepository adressenRepository;
    private final AdressenMapper adressenMapper;

    public Adresse getAdresseWithId(int id) {
        return adressenRepository.findById(id);
    }

    public List<Adresse> getAdresseById(Integer id) {
        return adressenRepository
                .findByKundenid(id);
    }

    public List<AdresseResponse> getAdresse (Integer id) {
        List<Adresse> adresse = adressenRepository.findByKundenid(id);
        List<AdresseResponse> list = adressenMapper.mapToResponseListe(adresse);
        return list;
    }

    public Adresse createAdresse(int kundenid, Adresse adresse) {
        adresse.setKundenid(kundenid);
        return adressenRepository.save(adresse);
    }

    public Adresse updateAdresse(int id, Adresse adresse) {
        Adresse oldAdresse = adressenRepository.findById(id);
        if (adresse.getStrasse() != null) {
            oldAdresse.setStrasse(adresse.getStrasse());
        }
        if (adresse.getOrt() != null) {
            oldAdresse.setOrt(adresse.getOrt());
        }
        if (adresse.getPlz() != null) {
            oldAdresse.setPlz(adresse.getPlz());
        }

        return adressenRepository.save(oldAdresse);
    }

    public void deleteAdressenById(int id) {
        adressenRepository.deleteById(id);
    }

    public void deleteAdressenByKundenid(int id) {
        adressenRepository.deleteAdresseByKundenid(id);
    }
}
