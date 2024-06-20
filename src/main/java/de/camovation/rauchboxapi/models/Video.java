package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "video")
@Data
public class Video {

    @Id
    @GeneratedValue
    private int id;

    private int kundenid;

    private String bezeichnung;

    private String extipadr;

    private String intipadr;
}