package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WartungRequest {
    
    private int id;

    @NotEmpty
    private int kundenid;

    @NotEmpty
    private int vertrag;

    @NotEmpty
    private int vertraginterval;

}
