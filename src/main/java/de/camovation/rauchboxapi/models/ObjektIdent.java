package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "objektident")
@Data
public class ObjektIdent {
    

    @Id
    @GeneratedValue
    private int id;

    private int kundenid;

    private int identnummer;

    private String leitstelle;

    private String objektart;

    private int Adressenid;


}