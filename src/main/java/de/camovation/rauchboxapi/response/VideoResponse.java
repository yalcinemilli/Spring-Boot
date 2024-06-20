package de.camovation.rauchboxapi.response;

import java.util.List;

import lombok.Data;

@Data
public class VideoResponse {
    private int id;

    private int kundenid;

    private String extipadr;

    private String intipadr;

    private String bezeichnung;

    private List<CustomFieldResponse> customfields;
}
