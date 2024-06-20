package de.camovation.rauchboxapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.camovation.rauchboxapi.models.CustomField;
import de.camovation.rauchboxapi.repository.CustomFieldRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomFieldService {
    
    private final CustomFieldRepository customFieldRepository;

    public void deleteCustomFieldById(int id) {
        customFieldRepository.deleteById(id);
    }

    public List<CustomField> getCustomFields(String objectid) {
        return customFieldRepository
                .findByObjectid(objectid);
    }

    public CustomField createCustomField(String objectid, CustomField customField) {
        customField.setObjectid(objectid);
        return customFieldRepository.save(customField);
    }

    public CustomField updateCustomField(int id, CustomField customField) {
        CustomField oldCustomField = customFieldRepository.findById(id);
        if (customField.getFieldname() != null) {
            oldCustomField.setFieldname(customField.getFieldname());
        }
        if (customField.getFieldvalue() != null) {
            oldCustomField.setFieldvalue(customField.getFieldvalue());
        }

        return customFieldRepository.save(oldCustomField);
    }
}
