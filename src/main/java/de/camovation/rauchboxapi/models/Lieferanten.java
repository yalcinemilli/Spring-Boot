package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "lieferanten")
@Data
public class Lieferanten {
    
    @Id
    @GeneratedValue
    private int id;

    private String lieferantenname;

    private String kundennummer;

    private String supporttelefon;

    private String ansprechpartner;
}
