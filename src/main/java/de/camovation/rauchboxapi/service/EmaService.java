package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.models.Ema;
import de.camovation.rauchboxapi.repository.EmaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmaService {
    
    private final EmaRepository emaRepository;
    
    public void deleteEmaById(int id) {
        emaRepository.deleteById(id);
    }

    public void deleteEmaByKundenid(int id) {
        emaRepository.deleteEmaByKundenid(id);
    }

    public List<Ema> getEmaById(Integer id) {
        return emaRepository
                .findByKundenid(id);
     
    }

    public Ema createEma(int kundenid, Ema ema) {
        ema.setKundenid(kundenid);
        return emaRepository.save(ema);
    }

    public Ema updateEma(int id, Ema ema) {
        Ema oldEma = emaRepository.findById(id);
        if (oldEma.getExtipadr() != null) {
            oldEma.setExtipadr(ema.getExtipadr());
        }
        if (oldEma.getIntipadr() != null) {
            oldEma.setIntipadr(ema.getIntipadr());
        }
        if (oldEma.getErrichtercode() != null) {
            oldEma.setErrichtercode(ema.getErrichtercode());
        }
        if (oldEma.getKundencode() != null) {
            oldEma.setKundencode(ema.getKundencode());
        }
        if (oldEma.getEmz() != null) {
            oldEma.setEmz(ema.getEmz());
        }
        if (oldEma.getUg() != null) {
            oldEma.setUg(ema.getUg());
        }

        return emaRepository.save(oldEma);
    }
}
