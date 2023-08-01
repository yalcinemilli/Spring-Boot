package de.camovation.rauchboxapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue
    private int id;

    private int kundenid;

    private String extipadr;

    private String intipadr;

    private String kameranetzwerk;

    private String dnsserver;

    private String switchzugang;

    private String windowszugang;

    private String nvrzugang;

    private String kamerazugang;

    private String camozugang;
}