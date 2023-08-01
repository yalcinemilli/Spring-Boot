package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmaRequest {
    
    private int id;

    private String extipadr;

    private String intipadr;

    private String errichtercode;

    private String kundencode;

    private String emz;

    private String ug;

    @NotEmpty
    private int kundenid;
}
