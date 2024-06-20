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

    private int vertrag = 0;

    private int first_quartal = 0;

    private int second_quartal = 0;

    private int third_quartal = 0;

    private int fourth_quartal = 0;
}
