package de.camovation.rauchboxapi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.exception.ErrorCode;
import de.camovation.rauchboxapi.exception.ServiceFehlerHandler;
import de.camovation.rauchboxapi.models.Kunde;
import de.camovation.rauchboxapi.repository.AdressenRepository;
import de.camovation.rauchboxapi.repository.EmaRepository;
import de.camovation.rauchboxapi.repository.KontaktRepository;
import de.camovation.rauchboxapi.repository.KundenRepository;
import de.camovation.rauchboxapi.repository.VideoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KundenService {

    private final AdressenRepository adressenRepository;
    private final EmaRepository emaRepository;
    private final KontaktRepository kontaktRepository;
    private final KundenRepository kundeRepository;
    private final VideoRepository videoRepository;
    
    public Page<Kunde> getAllKunden(Integer page, Integer size) {
        return kundeRepository.findAll(PageRequest.of(page, size));
    }
    
    public Kunde getKundeById(Integer id) {
        return kundeRepository
                .findById(id)
                .orElseThrow(() ->
                        new ServiceFehlerHandler(
                            ErrorCode.CUSTOMER_NOT_FOUND,
                            "Kunde mit der id: %s wurde nicht gefunden".formatted(id)
                        )
                );
    }

    public Kunde createKunde(Kunde kunde) {
        
        Optional<Kunde> optionalKundenname = kundeRepository.findByKundenname(kunde.getKundenname());
        if (optionalKundenname.isPresent()) {
            throw new ServiceFehlerHandler(
                    ErrorCode.CUSTOMER_EXISTS,
                    "Kunde mit dem Namen %s existiert bereits".formatted(kunde.getKundenname())
            );
        }

        Optional<Kunde> optionalIdentnummer = kundeRepository.findByIdentnummer(kunde.getIdentnummer());
        if (optionalIdentnummer.isPresent()) {
            throw new ServiceFehlerHandler(
                    ErrorCode.CUSTOMER_EXISTS,
                    "Kunde mit der Identnummer %s existiert bereits".formatted(kunde.getIdentnummer())
            );
        }

        return kundeRepository.save(kunde);
    }

    public Kunde updateKunde(int id, Kunde kunde) {
        Kunde oldKunde = getKundeById(id);
        if (kunde.getKundenname() != null) {
            oldKunde.setKundenname(kunde.getKundenname());
        }
        if (kunde.getIdentnummer() != null) {
            oldKunde.setIdentnummer(kunde.getIdentnummer());
        }
        return kundeRepository.save(oldKunde);
    }

    public void deleteKunde(int id) {

        adressenRepository.deleteByKundenid(id);
        emaRepository.deleteByKundenid(id);
        kontaktRepository.deleteByKundenid(id);
        videoRepository.deleteByKundenid(id);
        kundeRepository.deleteById(id);
    }

}