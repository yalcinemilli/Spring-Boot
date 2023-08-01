package de.camovation.rauchboxapi.request;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LeitstellenRequest {
    
    @Id
    private int id;
    @NotEmpty
    private int kundenid;
    @NotEmpty
    private String leitstelle;

    private String kennwort;
    @NotEmpty
    private String telefon;
}
