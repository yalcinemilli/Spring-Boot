package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.CustomField;
import de.camovation.rauchboxapi.request.CustomFieldRequest;
import de.camovation.rauchboxapi.response.CustomFieldResponse;

@Mapper
public interface CustomFieldMapper {
    
    CustomField mapToModel(CustomFieldRequest request);
    CustomFieldResponse mapToResponse(CustomField customField);
    List<CustomFieldResponse> mapToResponseListe(List<CustomField> customFields);
}
