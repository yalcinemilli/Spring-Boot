package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ema")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ema {
    
    @Id
    @GeneratedValue
    private int id;

    private String extipadr;

    private String intipadr;

    private String errichtercode;

    private String kundencode;

    private String emz;

    private String ug;

    private int kundenid;


}
