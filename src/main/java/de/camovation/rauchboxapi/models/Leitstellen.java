package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "leitstellen")
@Data
public class Leitstellen {

    @Id
    @GeneratedValue
    private int id;

    private int kundenid;

    private String leitstelle;

    private String kennwort;

    private String telefon;

    
}
