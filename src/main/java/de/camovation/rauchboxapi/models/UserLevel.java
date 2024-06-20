package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users-level")
@Data
public class UserLevel {
    
    @Id
    @GeneratedValue
    private int id;

    private String levelname;
}
