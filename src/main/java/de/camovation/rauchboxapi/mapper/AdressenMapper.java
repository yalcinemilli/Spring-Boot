package de.camovation.rauchboxapi.mapper;
import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.Adresse;
import de.camovation.rauchboxapi.request.AdressenRequest;
import de.camovation.rauchboxapi.response.AdresseResponse;

@Mapper
public interface AdressenMapper {
 
    Adresse mapToModel(AdressenRequest request);
    AdresseResponse mapToResponse(Adresse adresse);
    List<AdresseResponse> mapToResponseListe(List<Adresse> adressen);

}
