package de.camovation.rauchboxapi.response;

import java.util.List;

import lombok.Data;

@Data
public class KundeResponse {
       
    private int id;
    
    private String kundenname;
    
    private List<VideoResponse> videos;

    private List<EmaResponse> emas;

    private List<AdresseResponse> adressen;

    private List<KontaktResponse> kontakte;

    private List<WartungResponse> wartungen;

    private List<ObjektIdentResponse> objektidents;

}
