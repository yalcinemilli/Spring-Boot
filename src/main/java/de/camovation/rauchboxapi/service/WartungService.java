package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.mapper.CustomFieldMapper;
import de.camovation.rauchboxapi.mapper.WartungMapper;
import de.camovation.rauchboxapi.models.Wartung;
import de.camovation.rauchboxapi.repository.WartungRepository;
import de.camovation.rauchboxapi.response.WartungResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class WartungService {
   
    private final WartungRepository wartungRepository;
    private final WartungMapper wartungMapper;
    private final CustomFieldService customFieldService;
    private final CustomFieldMapper customFieldMapper;

    public void deleteWartungById(int id) {
        wartungRepository.deleteById(id);
    }

    public void deleteWartungByKundenid(int id) {
        wartungRepository.deleteWartungByKundenid(id);
    }

    public List<WartungResponse> getWartungById(Integer id) {
        List<Wartung> wartung = wartungRepository.findByKundenid(id);
        List<WartungResponse> list = wartungMapper.mapToResponseListe(wartung);
        list.forEach(wartungResponse -> {
            wartungResponse.setCustomfields(
                
            customFieldMapper.mapToResponseListe(customFieldService.getCustomFields("wartung" + id)));
        });
        return list;
    }

    public Wartung createWartung(int kundenid, Wartung wartung) {
        wartung.setKundenid(kundenid);
        return wartungRepository.save(wartung);
    }

    public Wartung updateWartung(int id, Wartung wartung) {
        Wartung oldWartung = wartungRepository.findById(id);
        if (wartung.getVertrag() != oldWartung.getVertrag()) {
            oldWartung.setVertrag(wartung.getVertrag());
        }
        if (wartung.getFirst_quartal() != oldWartung.getFirst_quartal()) {
            oldWartung.setFirst_quartal(wartung.getFirst_quartal());
        }
        if (wartung.getSecond_quartal() != oldWartung.getSecond_quartal()) {
            oldWartung.setSecond_quartal(wartung.getSecond_quartal());
        }
        if (wartung.getThird_quartal() != oldWartung.getThird_quartal()) {
            oldWartung.setThird_quartal(wartung.getThird_quartal());
        }
        if (wartung.getFourth_quartal() != oldWartung.getFourth_quartal()) {
            oldWartung.setFourth_quartal(wartung.getFourth_quartal());
        }
        return wartungRepository.save(oldWartung);
    }
}
