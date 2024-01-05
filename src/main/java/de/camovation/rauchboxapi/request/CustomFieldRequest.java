package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomFieldRequest {
    
    private int id;
    
    @NotEmpty
    private String objectid;

    @NotEmpty
    private String fieldname;
    
    @NotEmpty
    private String fieldvalue;
}
