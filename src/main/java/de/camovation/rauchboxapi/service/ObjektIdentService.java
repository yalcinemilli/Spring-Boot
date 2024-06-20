package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.mapper.AdressenMapper;
import de.camovation.rauchboxapi.mapper.ObjektIdentMapper;
import de.camovation.rauchboxapi.models.ObjektIdent;
import de.camovation.rauchboxapi.repository.ObjektIdentRepository;
import de.camovation.rauchboxapi.response.ObjektIdentResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ObjektIdentService {
    
    private final ObjektIdentRepository objektIdentRepository;
    private final ObjektIdentMapper objektIdentMapper;
    private final AdressenService adressenService;
    private final AdressenMapper adressenMapper;
    
    public void deleteObjektIdentById(int id) {
        objektIdentRepository.deleteById(id);
    }

    public void deleteObjektIdentByKundenid(int id) {
        objektIdentRepository.deleteObjektIdentByKundenid(id);
    }

    public List<ObjektIdentResponse> getObjektIdent (Integer id) {
        List<ObjektIdent> objektIdent = objektIdentRepository.findByKundenid(id);
        List<ObjektIdentResponse> list = objektIdentMapper.mapToResponseListe(objektIdent);
        list.forEach(objektIdentResponse -> {
            objektIdentResponse.setAdresse(
                adressenMapper.mapToResponse(adressenService.getAdresseWithId(objektIdentResponse.getAdressenid())
                ));
        });
        return list;
    }
    public List<ObjektIdent> getObjektIdentById(Integer id) {
        return objektIdentRepository
                .findByKundenid(id);
     
    }
    public ObjektIdent createObjektIdent(int kundenid, ObjektIdent objektIdent, int adressenid) {
        objektIdent.setAdressenid(adressenid);
        objektIdent.setKundenid(kundenid);
        return objektIdentRepository.save(objektIdent);
    }

    public ObjektIdent updateObjektIdent(int id, ObjektIdent objektIdent) {
        ObjektIdent oldObjektIdent = objektIdentRepository.findById(id);
        if (objektIdent.getLeitstelle() != null) {
            oldObjektIdent.setLeitstelle(objektIdent.getLeitstelle());
        }
        if (objektIdent.getObjektart() != null) {
            oldObjektIdent.setObjektart(objektIdent.getObjektart());
        }
        if (objektIdent.getIdentnummer() != 0) {
            oldObjektIdent.setIdentnummer(objektIdent.getIdentnummer());
        }
        if (objektIdent.getAdressenid() != 0) {
            oldObjektIdent.setAdressenid(objektIdent.getAdressenid());
        }

        return objektIdentRepository.save(oldObjektIdent);
    }
}
