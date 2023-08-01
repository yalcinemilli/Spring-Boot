package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.Lieferanten;
import de.camovation.rauchboxapi.request.LieferantenRequest;
import de.camovation.rauchboxapi.response.LieferantenResponse;

@Mapper
public interface LieferantenMapper {
    
    Lieferanten mapToModel(LieferantenRequest request);
    LieferantenResponse mapToResponse(Lieferanten lieferanten);
    List<LieferantenResponse> mapToResponseListe(List<Lieferanten> lieferanten);
}
