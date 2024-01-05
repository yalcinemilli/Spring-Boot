package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "kontakte")
@Data
public class Kontakt {
    
    @Id
    @GeneratedValue
    private int id;

    private int kundenid;

    private String ansprechpartner;

    private String telefon;

    private String email;
    
    private String notizen;
}
