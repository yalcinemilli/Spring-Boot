package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLevelRequest {
    

    private int id;
    @NotEmpty
    private String levelname;
}
