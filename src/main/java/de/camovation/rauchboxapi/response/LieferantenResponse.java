package de.camovation.rauchboxapi.response;

import lombok.Data;

@Data
public class LieferantenResponse {
    private int id;

    private String lieferantenname;

    private String kundennummer;

    private String supporttelefon;

    private String ansprechpartner;
}
