package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.Ema;
import de.camovation.rauchboxapi.request.EmaRequest;
import de.camovation.rauchboxapi.response.EmaResponse;

@Mapper
public interface EmaMapper {
    
    Ema mapToModel(EmaRequest request);
    EmaResponse mapToResponse(Ema ema);
    List<EmaResponse> mapToResponseListe(List<Ema> emas);
}
