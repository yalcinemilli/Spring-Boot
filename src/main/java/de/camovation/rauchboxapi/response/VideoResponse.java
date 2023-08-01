package de.camovation.rauchboxapi.response;

import lombok.Data;

@Data
public class VideoResponse {
    private int id;

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
