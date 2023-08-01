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

import de.camovation.rauchboxapi.mapper.EmaMapper;
import de.camovation.rauchboxapi.models.Ema;
import de.camovation.rauchboxapi.repository.EmaRepository;
import de.camovation.rauchboxapi.response.EmaResponse;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.service.EmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/ema")
public class EmaController {
    
    private final EmaRepository emaRepository;
    private final EmaMapper emaMapper;
    private final EmaService emaService;
    
    @GetMapping("/{id}")
      public ResponseEntity<ListResponse<EmaResponse>> getEmas(@PathVariable int id) {
        List<Ema> ema = emaRepository.findByKundenid(id);
        
        List<EmaResponse> list = emaMapper.mapToResponseListe(ema);

        ListResponse<EmaResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

        @PostMapping("/erstellen/{id}")
    public ResponseEntity<EmaResponse> createEma(@PathVariable int id, @RequestBody @Valid Ema request) {
        Ema createdEma = emaService.createEma(id, request);
        EmaResponse response = emaMapper.mapToResponse(createdEma);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

        @PutMapping("/bearbeiten/{id}")
    public ResponseEntity<EmaResponse> updateEma(@PathVariable int id, @RequestBody @Valid Ema request) {
        Ema updatedEma = emaService.updateEma(id, request);
        EmaResponse response = emaMapper.mapToResponse(updatedEma);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteEma(@PathVariable int id) {
       emaService.deleteEmaById(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/kundenid/{id}")
    public ResponseEntity<Void> deleteEmaByKundenid(@PathVariable int id) {
       emaService.deleteEmaByKundenid(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
