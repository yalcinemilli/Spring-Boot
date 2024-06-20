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

import de.camovation.rauchboxapi.mapper.LeitstellenMapper;
import de.camovation.rauchboxapi.models.Leitstellen;
import de.camovation.rauchboxapi.repository.LeitstellenRepository;
import de.camovation.rauchboxapi.response.LeitstellenResponse;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.service.LeitstellenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/leitstellen")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LeitstellenController {
    
    private final LeitstellenRepository leitstellenRepository;
    private final LeitstellenMapper leitstellenMapper;
    private final LeitstellenService leitstellenService;

    @GetMapping("/{id}")
    public ResponseEntity<ListResponse<LeitstellenResponse>> getLeitstellen(@PathVariable int id) {
        List<Leitstellen> leitstellen = leitstellenRepository.findByKundenid(id);
        
        List<LeitstellenResponse> list = leitstellenMapper.mapToResponseListe(leitstellen);

        ListResponse<LeitstellenResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/alle")
    public ResponseEntity<ListResponse<LeitstellenResponse>> getLeitstellen() {
        List<Leitstellen> leitstellen = leitstellenRepository.findAll();
        
        List<LeitstellenResponse> list = leitstellenMapper.mapToResponseListe(leitstellen);

        ListResponse<LeitstellenResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/erstellen")
    public ResponseEntity<LeitstellenResponse> createLeitstellen(@RequestBody Leitstellen leitstellen) {
        Leitstellen createdLeitstellen = leitstellenService.createLeitstelle(leitstellen);
        LeitstellenResponse response = leitstellenMapper.mapToResponse(createdLeitstellen);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<LeitstellenResponse> updateLeitstellen(@PathVariable int id, @RequestBody Leitstellen leitstellen) {
        Leitstellen updatedLeitstellen = leitstellenService.updateLeitstelle(id, leitstellen);
        LeitstellenResponse response = leitstellenMapper.mapToResponse(updatedLeitstellen);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<LeitstellenResponse> deleteLeitstellen(@PathVariable int id) {
        Leitstellen leitstellen = leitstellenRepository.findById(id);
        leitstellenRepository.delete(leitstellen);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
