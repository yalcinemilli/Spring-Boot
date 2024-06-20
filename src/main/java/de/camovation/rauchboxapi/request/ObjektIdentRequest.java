package de.camovation.rauchboxapi.request;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ObjektIdentRequest {
    
    @Id
    private int id;

    @NotEmpty
    private int kundenid;
    @NotEmpty
    private int identnummer;
    @NotEmpty
    private String leitstelle;
    @NotEmpty
    private String objektart;
    @NotEmpty
    private int Adressenid;
}
