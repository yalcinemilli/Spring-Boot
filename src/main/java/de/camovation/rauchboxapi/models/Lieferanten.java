package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lieferanten")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Lieferanten {
    
    @Id
    @GeneratedValue
    private int id;

    private String lieferantenname;

    private String kundennummer;

    private String supporttelefon;

    private String ansprechpartner;
}
