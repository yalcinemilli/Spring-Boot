package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.Leitstellen;
import de.camovation.rauchboxapi.request.LeitstellenRequest;
import de.camovation.rauchboxapi.response.LeitstellenResponse;

@Mapper
public interface LeitstellenMapper {
    
    Leitstellen mapToModel(LeitstellenRequest request);
    LeitstellenResponse mapToResponse(Leitstellen leitstellen);
    List<LeitstellenResponse> mapToResponseListe(List<Leitstellen> leitstellen);
    
}
