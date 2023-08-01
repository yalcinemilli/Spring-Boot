package de.camovation.rauchboxapi.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class VideoRequest {
    
    private int id;
    @NotEmpty
    private int kundenid;

    private String extipadr;

    private String intipadr;

    private String kameranetzwerk;

    private String dnsserver;

    private String switchzugang;

    private String windowszugang;

    private String nvrzugang;

    private String kamerazugang;

    private String camozugang;
}
