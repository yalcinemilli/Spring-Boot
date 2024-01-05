package de.camovation.rauchboxapi.controller;

import java.util.List;

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

import de.camovation.rauchboxapi.mapper.CustomFieldMapper;
import de.camovation.rauchboxapi.mapper.WartungMapper;
import de.camovation.rauchboxapi.models.Wartung;
import de.camovation.rauchboxapi.repository.WartungRepository;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.response.WartungResponse;
import de.camovation.rauchboxapi.service.CustomFieldService;
import de.camovation.rauchboxapi.service.WartungService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/wartungvertrag")
@CrossOrigin(origins = "http://localhost:4200")
public class WartungController {

    private final WartungRepository wartungRepository;
    private final WartungMapper wartungMapper;
    private final WartungService wartungService;
    private final CustomFieldMapper customFieldMapper;
    private final CustomFieldService customFieldService;

    @GetMapping("/{id}")
    public ResponseEntity<ListResponse<WartungResponse>> getWartung(@PathVariable int id) {
        List<Wartung> wartung = wartungRepository.findByKundenid(id);
        
        List<WartungResponse> list = wartungMapper.mapToResponseListe(wartung);
        list.forEach(wartungResponse -> {
            wartungResponse.setCustomfields(
                
            customFieldMapper.mapToResponseListe(customFieldService.getCustomFields("wartung" + id)));
        });
        ListResponse<WartungResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/erstellen/{id}")
    public ResponseEntity<WartungResponse> createWartung(@PathVariable int id, @RequestBody @Valid Wartung wartung) {
        Wartung createdWartung = wartungService.createWartung(id, wartung);
        WartungResponse response = wartungMapper.mapToResponse(createdWartung);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<WartungResponse> updateWartung(@PathVariable int id, @RequestBody @Valid Wartung wartung) {
        Wartung updatedWartung = wartungService.updateWartung(id, wartung);
        WartungResponse response = wartungMapper.mapToResponse(updatedWartung);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<WartungResponse> deleteWartung(@PathVariable int id) {
        wartungService.deleteWartungById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/kundenid/{id}")
    public ResponseEntity<WartungResponse> deleteWartungByKundenid(@PathVariable int id) {
        wartungService.deleteWartungByKundenid(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
