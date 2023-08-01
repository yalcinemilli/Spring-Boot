package de.camovation.rauchboxapi.response;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserResponse {
    private int id;

    private String vorname;

    private String nachname;

    private String email;

    private String pwd;

    private int userlevel;

    private Timestamp lastlogin;
}
