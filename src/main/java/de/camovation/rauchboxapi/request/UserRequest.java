package de.camovation.rauchboxapi.request;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRequest {
    
    @Id
    private int id;
    @NotEmpty
    private String vorname;
    @NotEmpty
    private String nachname;
    @Email
    private String email;
    @NotEmpty
    private String pwd;

//    @NotEmpty
    private int userlevel;
    

    @Column(name = "lastlogin", columnDefinition = "TIMESTAMP")
    private Timestamp lastlogin;

    private String secretcode;
    @NotEmpty
    private int is2fa;
}
