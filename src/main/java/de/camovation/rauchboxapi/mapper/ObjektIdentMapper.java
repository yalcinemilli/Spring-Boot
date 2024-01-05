package de.camovation.rauchboxapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.camovation.rauchboxapi.models.ObjektIdent;
import de.camovation.rauchboxapi.request.ObjektIdentRequest;
import de.camovation.rauchboxapi.response.ObjektIdentResponse;

@Mapper
public interface ObjektIdentMapper {
    
     ObjektIdent mapToModel(ObjektIdentRequest request);
     ObjektIdentResponse mapToResponse(ObjektIdent objektIdent);
     List<ObjektIdentResponse> mapToResponseListe(List<ObjektIdent> objektIdents);
}
