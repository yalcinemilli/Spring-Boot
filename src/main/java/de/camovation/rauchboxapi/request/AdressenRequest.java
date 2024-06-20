package de.camovation.rauchboxapi.request;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AdressenRequest {
    
    @Id
    private int id;
    @NotEmpty
    private int kundenid;
    @NotEmpty
    private String strasse;
    @NotEmpty
    private String plz;
    @NotEmpty
    private String ort;
    
}

