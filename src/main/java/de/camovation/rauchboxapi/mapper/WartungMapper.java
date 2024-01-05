package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.Wartung;
import de.camovation.rauchboxapi.response.WartungResponse;

@Mapper
public interface WartungMapper {
    

    Wartung mapToModel(Wartung wartung);
    WartungResponse mapToResponse(Wartung wartung);
    List<WartungResponse> mapToResponseListe(List<Wartung> wartungen);

}
