package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmaRequest {
    
    private int id;

    private String extipadr;

    private String intipadr;

    @NotEmpty
    private String bezeichnung;

    @NotEmpty
    private int kundenid;
}
