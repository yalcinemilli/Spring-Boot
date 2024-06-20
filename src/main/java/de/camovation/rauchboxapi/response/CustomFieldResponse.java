package de.camovation.rauchboxapi.response;

import lombok.Data;

@Data
public class CustomFieldResponse {
    
    private int id;
    
    private String objectid;

    private String fieldname;
    
    private String fieldvalue;


}
