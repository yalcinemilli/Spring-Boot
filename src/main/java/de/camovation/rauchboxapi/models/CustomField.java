package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customfield")
@Data
public class CustomField {
    
    @Id
    @GeneratedValue
    private int id;

    private String objectid;

    private String fieldname;

    private String fieldvalue;
}
