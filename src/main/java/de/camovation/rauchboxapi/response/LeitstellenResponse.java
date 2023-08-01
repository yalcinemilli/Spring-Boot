package de.camovation.rauchboxapi.response;

import lombok.Data;

@Data
public class LeitstellenResponse {
    private int id;

    private int kundenid;

    private String leitstelle;

    private String kennwort;

    private String telefon;
}
