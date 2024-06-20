package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.UserLevel;
import de.camovation.rauchboxapi.request.UserLevelRequest;
import de.camovation.rauchboxapi.response.UserLevelResponse;

@Mapper
public interface UserLevelMapper {
    
    UserLevel mapToModel(UserLevelRequest request);
    UserLevelResponse mapToResponse(UserLevel userLevel);
    List<UserLevelResponse> mapToResponseListe(List<UserLevel> userLevels);
}
