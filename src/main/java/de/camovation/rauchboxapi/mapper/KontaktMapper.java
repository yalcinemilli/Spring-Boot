package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.Kontakt;
import de.camovation.rauchboxapi.request.KontaktRequest;
import de.camovation.rauchboxapi.response.KontaktResponse;

@Mapper
public interface KontaktMapper {
    
    Kontakt mapToModel(KontaktRequest request);
    KontaktResponse mapToResponse(Kontakt kontakt);
    List<KontaktResponse> mapToResponseListe(List<Kontakt> kontakte);
    
}
