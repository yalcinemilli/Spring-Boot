package de.camovation.rauchboxapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.camovation.rauchboxapi.mapper.KontaktMapper;
import de.camovation.rauchboxapi.models.Kontakt;
import de.camovation.rauchboxapi.repository.KontaktRepository;
import de.camovation.rauchboxapi.response.KontaktResponse;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.service.KontaktService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/kontakte")
@RequiredArgsConstructor

public class KontaktController {
    
    private final KontaktRepository kontaktRepository;
    private final KontaktMapper kontaktMapper;
    private final KontaktService kontaktService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ListResponse<KontaktResponse>> getKontakte(@PathVariable int id) {
        List<Kontakt> kontakte = kontaktRepository.findByKundenid(id);
        if(kontakte.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<KontaktResponse> list = kontaktMapper.mapToResponseListe(kontakte);

        ListResponse<KontaktResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PostMapping("/erstellen/{id}")
    public ResponseEntity<KontaktResponse> createKontakt(@PathVariable int id, @RequestBody @Valid Kontakt request) {
        Kontakt createdKontakt = kontaktService.createKontakt(id, request);
        KontaktResponse response = kontaktMapper.mapToResponse(createdKontakt);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

        @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<KontaktResponse> updateKontakt(@PathVariable int id, @RequestBody @Valid Kontakt request) {
        Kontakt updatedKontakt = kontaktService.updateKontakt(id, request);
        KontaktResponse response = kontaktMapper.mapToResponse(updatedKontakt);
     
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteKontakt(@PathVariable int id) {
        kontaktService.deleteKontaktById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/kundenid/{id}")
    public ResponseEntity<Void> deleteKontaktByKundenid(@PathVariable int id) {
        kontaktService.deleteKontaktByKundenid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
