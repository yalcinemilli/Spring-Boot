package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.User;
import de.camovation.rauchboxapi.request.UserRequest;
import de.camovation.rauchboxapi.response.UserResponse;

@Mapper
public interface UserMapper {
    
    User mapToModel(UserRequest request);
    UserResponse mapToResponse(User user);
    List<UserResponse> mapToResponseListe(List<User> users);
}
