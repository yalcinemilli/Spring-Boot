package de.camovation.rauchboxapi.response;

import java.util.List;

import lombok.Data;

@Data
public class WartungResponse {
    
    private int id;

    private int kundenid;

    private int vertrag;

    private int vertraginterval;

    private List<CustomFieldResponse> customfields;
}
