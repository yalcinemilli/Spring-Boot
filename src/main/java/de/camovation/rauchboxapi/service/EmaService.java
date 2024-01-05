package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.mapper.CustomFieldMapper;
import de.camovation.rauchboxapi.mapper.EmaMapper;
import de.camovation.rauchboxapi.models.Ema;
import de.camovation.rauchboxapi.repository.EmaRepository;
import de.camovation.rauchboxapi.response.EmaResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmaService {
    
    private final EmaRepository emaRepository;
    private final CustomFieldService customFieldService;
    private final CustomFieldMapper customFieldMapper;
    private final EmaMapper emaMapper;
    
    public void deleteEmaById(int id) {
        emaRepository.deleteById(id);
    }

    public void deleteEmaByKundenid(int id) {
        emaRepository.deleteEmaByKundenid(id);
    }

    public List<EmaResponse> getEmaById(Integer id) {
        List<Ema> ema = emaRepository.findByKundenid(id);
        List<EmaResponse> list = emaMapper.mapToResponseListe(ema);
        list.forEach(emaResponse -> {
            emaResponse.setCustomfields(
                
            customFieldMapper.mapToResponseListe(customFieldService.getCustomFields("ema" + emaResponse.getId())));
        });
        return list;
    }

    public Ema createEma(int kundenid, Ema ema) {
        ema.setKundenid(kundenid);
        return emaRepository.save(ema);
    }

    public Ema updateEma(int id, Ema ema) {
        Ema oldEma = emaRepository.findById(id);
        if (ema.getExtipadr() != null) {
            oldEma.setExtipadr(ema.getExtipadr());
        }
        if (ema.getIntipadr() != null) {
            oldEma.setIntipadr(ema.getIntipadr());
        }
        if (ema.getBezeichnung() != null) {
            oldEma.setBezeichnung(ema.getBezeichnung());
        }

        return emaRepository.save(oldEma);
    }
}
