package de.camovation.rauchboxapi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.camovation.rauchboxapi.mapper.KundenMapper;
import de.camovation.rauchboxapi.models.Kunde;
import de.camovation.rauchboxapi.repository.KundenRepository;
import de.camovation.rauchboxapi.response.KundeResponse;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.service.AdressenService;
import de.camovation.rauchboxapi.service.EmaService;
import de.camovation.rauchboxapi.service.KontaktService;
import de.camovation.rauchboxapi.service.KundenService;
import de.camovation.rauchboxapi.service.ObjektIdentService;
import de.camovation.rauchboxapi.service.VideoService;
import de.camovation.rauchboxapi.service.WartungService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/v1/kundendaten")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class KundenController {
    
    private final KundenService kundenService;
    private final KundenMapper kundenMapper;
    private final KundenRepository kundenRepository;
    private final EmaService emaService;
    private final VideoService videoService;
    private final AdressenService adressenService;
    private final KontaktService kontaktService;
    private final WartungService wartungService;
    private final ObjektIdentService objektIdentService;


    @GetMapping("/all")
    public ResponseEntity<ListResponse<KundeResponse>> getKunden(Integer page, Integer size) {
        Page<Kunde> pageObject = kundenService.getAllKunden(page, size);

        List<KundeResponse> list = kundenMapper.mapToResponseListe(pageObject.toList());

        ListResponse<KundeResponse> response = new ListResponse<>(list, pageObject.stream().count());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

        @GetMapping("/alle")
    public ResponseEntity<ListResponse<KundeResponse>> getKundenAlle() {
        List<Kunde> kunden = kundenRepository.findAll();

        List<KundeResponse> list = kundenMapper.mapToResponseListe(kunden);

        ListResponse<KundeResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<KundeResponse> getKundeById(@PathVariable int id) {
        Kunde kunde = kundenService.getKundeById(id);
        KundeResponse response = kundenMapper.mapToResponse(kunde);
        response.setAdressen(adressenService.getAdresse(id));
        response.setKontakte(kontaktService.getKontakt(id));
        response.setEmas(emaService.getEmaById(id));
        response.setVideos(videoService.getVideo(id));
        response.setWartungen(wartungService.getWartungById(id));
        response.setObjektidents(objektIdentService.getObjektIdent(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/erstellen")
    public ResponseEntity<KundeResponse> createKunde(@RequestBody @Valid Kunde request) {
        Kunde createdKunde = kundenService.createKunde(request);
        KundeResponse response = kundenMapper.mapToResponse(createdKunde);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

        @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<KundeResponse> updateKunde(@PathVariable int id, @RequestBody @Valid Kunde request) {
        Kunde updatedKunde = kundenService.updateKunde(id, request);
        KundeResponse response = kundenMapper.mapToResponse(updatedKunde);
     
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteKunde(@PathVariable int id) {
        kundenService.deleteKunde(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
