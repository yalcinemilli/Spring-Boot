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
    private int first_quartal;

    @NotEmpty
    private int second_quartal;

    @NotEmpty
    private int third_quartal;

    @NotEmpty
    private int fourth_quartal;
}
