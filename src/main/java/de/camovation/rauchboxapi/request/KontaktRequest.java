package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class KontaktRequest {
    
    private int id;
    
    @NotEmpty
    private int kundenid;


    private String ansprechpartner;

    @NotEmpty
    private String telefon;

    @Email
    private String email;

    private String notizen;

    
}
