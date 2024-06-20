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

import de.camovation.rauchboxapi.mapper.ObjektIdentMapper;
import de.camovation.rauchboxapi.models.ObjektIdent;
import de.camovation.rauchboxapi.repository.ObjektIdentRepository;
import de.camovation.rauchboxapi.response.ListResponse;
import de.camovation.rauchboxapi.response.ObjektIdentResponse;
import de.camovation.rauchboxapi.service.ObjektIdentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/objektident")
@CrossOrigin(origins = "http://localhost:4200")
public class ObjektIdentController {

    private final ObjektIdentService objektIdentService;
    private final ObjektIdentMapper objektIdentMapper;
    private final ObjektIdentRepository objektIdentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ListResponse<ObjektIdentResponse>> getObjektIdent(@PathVariable int id) {
        List<ObjektIdent> objektIdent = objektIdentRepository.findByKundenid(id);
        
        List<ObjektIdentResponse> list = objektIdentMapper.mapToResponseListe(objektIdent);
        ListResponse<ObjektIdentResponse> response = new ListResponse<>(list, list.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/erstellen/{id}")
    public ResponseEntity<ObjektIdentResponse> createObjektIdent(@PathVariable int id, @RequestBody @Valid ObjektIdent objektIdent, int adresseid) {
        ObjektIdent createdObjektIdent = objektIdentService.createObjektIdent(id, objektIdent, adresseid);
        ObjektIdentResponse response = objektIdentMapper.mapToResponse(createdObjektIdent);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ObjektIdentResponse> updateObjektIdent(@PathVariable int id, @RequestBody @Valid ObjektIdent objektIdent) {
        ObjektIdent updatedObjektIdent = objektIdentService.updateObjektIdent(id, objektIdent);
        ObjektIdentResponse response = objektIdentMapper.mapToResponse(updatedObjektIdent);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteObjektIdent(@PathVariable int id) {
        objektIdentService.deleteObjektIdentById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
