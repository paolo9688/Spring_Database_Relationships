package com.example.jpa_relazioni.OneToOne.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Indirizzo {
    @Id
    private Long id;
    private String via;
    private String città;
}
