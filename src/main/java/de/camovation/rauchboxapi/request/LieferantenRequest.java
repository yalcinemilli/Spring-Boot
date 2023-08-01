package de.camovation.rauchboxapi.request;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LieferantenRequest {
    
    @Id
    private int id;
    @NotEmpty
    private String lieferantenname;

    private String kundennummer;
    @NotEmpty
    private String supporttelefon;

    private String ansprechpartner;
}
