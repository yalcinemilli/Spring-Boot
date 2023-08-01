package de.camovation.rauchboxapi.response;

import lombok.Data;

@Data
public class EmaResponse {

    private int id;

    private String extipadr;

    private String intipadr;

    private String errichtercode;

    private String kundencode;

    private String emz;

    private String ug;

    private int kundenid;
}
