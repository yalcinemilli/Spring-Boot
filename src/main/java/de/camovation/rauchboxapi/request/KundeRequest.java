package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class KundeRequest {
    
    private int id;
    
    @NotEmpty
    private String identnummer;
    @NotEmpty
    private String kundenname;

}
