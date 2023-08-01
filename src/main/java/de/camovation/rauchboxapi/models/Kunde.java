package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "kunden")
@Data
public class Kunde {
    
    @Id
    @GeneratedValue
    private int id;
    
    private String identnummer;
    
    private String kundenname;
    
}
