package de.camovation.rauchboxapi.response;

import lombok.Data;

@Data
public class KontaktResponse {
    private int id;

    private int kundenid;

    private String ansprechpartner;

    private String telefon;

    private String email;
    
    private String notizen;

}
