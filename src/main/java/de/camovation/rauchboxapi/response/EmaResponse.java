package de.camovation.rauchboxapi.response;

import java.util.List;

import lombok.Data;

@Data
public class EmaResponse {

    private int id;

    private String extipadr;

    private String intipadr;

    private String bezeichnung;

    private List<CustomFieldResponse> customfields;
}
