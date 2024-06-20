package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.Kunde;
import de.camovation.rauchboxapi.request.KundeRequest;
import de.camovation.rauchboxapi.response.KundeResponse;

@Mapper
public interface KundenMapper {

    Kunde mapToModel(KundeRequest request);

    KundeResponse mapToResponse(Kunde kunde);

    List<KundeResponse> mapToResponseListe(List<Kunde> kunden);
}
