package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "wartungsvertrag")
@Data
public class Wartung {
    
    @Id
    @GeneratedValue
    private int id;

    private int kundenid;

    private int vertrag;

    private int vertraginterval = 0;

}
