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

import de.camovation.rauchboxapi.mapper.LieferantenMapper;
import de.camovation.rauchboxapi.models.Lieferanten;
import de.camovation.rauchboxapi.repository.LieferantenRepository;
import de.camovation.rauchboxapi.response.LieferantenResponse;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.service.LieferantenService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/v1/lieferanten")
@RequiredArgsConstructor
public class LieferantenController {
  
    private final LieferantenRepository lieferantenRepository;
    private final LieferantenMapper lieferantenMapper;
    private final LieferantenService lieferantenService;

    @GetMapping("/{id}")
    public ResponseEntity<LieferantenResponse> getLieferanten(@PathVariable int id) {
        Lieferanten lieferanten = lieferantenRepository.findById(id);
        
        LieferantenResponse response = lieferantenMapper.mapToResponse(lieferanten);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/alle")
    public ResponseEntity<ListResponse<LieferantenResponse>> getLieferanten() {
        List<Lieferanten> lieferanten = lieferantenRepository.findAll();
        
        List<LieferantenResponse> list = lieferantenMapper.mapToResponseListe(lieferanten);

        ListResponse<LieferantenResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/erstellen")
    public ResponseEntity<LieferantenResponse> createLieferanten(@RequestBody Lieferanten lieferanten) {
        Lieferanten createdLieferanten = lieferantenService.createLieferanten(lieferanten);
        LieferantenResponse response = lieferantenMapper.mapToResponse(createdLieferanten);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<LieferantenResponse> updateLieferanten(@PathVariable int id, @RequestBody Lieferanten lieferanten) {
        Lieferanten updatedLieferanten = lieferantenService.updateLieferanten(id, lieferanten);
        LieferantenResponse response = lieferantenMapper.mapToResponse(updatedLieferanten);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteLieferanten(@PathVariable int id) {
        lieferantenService.deleteLieferantenById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}