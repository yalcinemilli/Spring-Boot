package de.camovation.rauchboxapi.response;

import java.util.List;

import lombok.Data;

@Data
public class WartungResponse {
    
    private int id;

    private int kundenid;

    private int vertrag;
    
    private int first_quartal;

    private int second_quartal;

    private int third_quartal;

    private int fourth_quartal;

    private List<CustomFieldResponse> customfields;
}
