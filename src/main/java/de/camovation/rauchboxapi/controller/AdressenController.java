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

import de.camovation.rauchboxapi.mapper.AdressenMapper;
import de.camovation.rauchboxapi.models.Adresse;
import de.camovation.rauchboxapi.repository.AdressenRepository;
import de.camovation.rauchboxapi.response.AdresseResponse;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.service.AdressenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/adressen")
@RequiredArgsConstructor
public class AdressenController {
    
    
    private final AdressenRepository adressenRepository;
    private final AdressenMapper adressenMapper;
    private final AdressenService adressenService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ListResponse<AdresseResponse>> getAdresses(@PathVariable int id) {
        List<Adresse> adressen = adressenRepository.findByKundenid(id);
        
        List<AdresseResponse> list = adressenMapper.mapToResponseListe(adressen);

        ListResponse<AdresseResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/erstellen/{id}")
    public ResponseEntity<AdresseResponse> createAdresse(@PathVariable int id, @RequestBody @Valid Adresse request) {
        
        Adresse createdAdresse = adressenService.createAdresse(id, request);
        AdresseResponse response = adressenMapper.mapToResponse(createdAdresse);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

        @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<AdresseResponse> updateAdresse(@PathVariable int id, @RequestBody @Valid Adresse request) {
        Adresse updatedAdresse = adressenService.updateAdresse(id, request);
        AdresseResponse response = adressenMapper.mapToResponse(updatedAdresse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteAdresse(@PathVariable int id) {
       adressenService.deleteAdressenById(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/kundenid/{id}")
    public ResponseEntity<Void> deleteAdresseByKundenid(@PathVariable int id) {
        adressenService.deleteAdressenByKundenid(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
