package de.camovation.rauchboxapi.response;

import lombok.Data;

@Data
public class ObjektIdentResponse {
    
    private int id;

    private int kundenid;

    private int identnummer;

    private String leitstelle;

    private String objektart;

    private int Adressenid;

    private AdresseResponse adresse;

}
