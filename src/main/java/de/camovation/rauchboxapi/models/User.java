package de.camovation.rauchboxapi.models;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    
    @Id
    @GeneratedValue
    private int id;

    private String vorname;

    private String nachname;

    private String email;

    private String pwd;

    private int userlevel;

    private Timestamp lastlogin;
    
    private String secretcode;
    
    private int is2fa = 0;
}
