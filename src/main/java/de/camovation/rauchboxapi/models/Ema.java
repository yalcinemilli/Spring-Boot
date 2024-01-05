package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ema")
@Data
public class Ema {
    
    @Id
    @GeneratedValue
    private int id;

    private String extipadr;

    private String intipadr;

    private String bezeichnung;

    private int kundenid;


}
