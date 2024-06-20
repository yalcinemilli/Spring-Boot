package de.camovation.rauchboxapi.response;

import lombok.Data;

@Data
public class AdresseResponse {
    
    private int id;
    
    private int kundenid;
    
    private String strasse;

    private String plz;

    private String ort;
}
