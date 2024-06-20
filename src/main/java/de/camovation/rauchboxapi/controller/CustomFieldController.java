package de.camovation.rauchboxapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.camovation.rauchboxapi.mapper.CustomFieldMapper;
import de.camovation.rauchboxapi.models.CustomField;
import de.camovation.rauchboxapi.response.CustomFieldResponse;
import de.camovation.rauchboxapi.service.CustomFieldService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/customfield")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomFieldController {
    
    private final CustomFieldService customFieldService;
    private final CustomFieldMapper customFieldMapper;


    @PostMapping("/erstellen/{id}")
    public ResponseEntity<CustomFieldResponse> createCustomField(@PathVariable String id, @RequestBody CustomField request) {
        CustomField createdCustomField = customFieldService.createCustomField(id, request);
        CustomFieldResponse response = customFieldMapper.mapToResponse(createdCustomField);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/bearbeiten/{id}")
    public ResponseEntity<CustomFieldResponse> updateCustomField(@PathVariable int id, @RequestBody CustomField request) {
        CustomField updatedCustomField = customFieldService.updateCustomField(id, request);
        CustomFieldResponse response = customFieldMapper.mapToResponse(updatedCustomField);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<CustomFieldResponse> deleteCustomField(@PathVariable int id) {
        customFieldService.deleteCustomFieldById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
