package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class VideoRequest {
    
    private int id;
    @NotEmpty
    private int kundenid;

    private String extipadr;

    private String intipadr;

    @NotEmpty
    private String bezeichnung;
}
