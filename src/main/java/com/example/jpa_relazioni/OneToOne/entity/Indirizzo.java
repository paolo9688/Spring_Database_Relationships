package com.example.jpa_relazioni.OneToOne.entity;

import jakarta.persistence.*;

@Entity
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String via;

    private String citta;

    public Indirizzo() {}

    public Indirizzo(Long id, String via, String citta) {
        this.id = id;
        this.via = via;
        this.citta = citta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "id=" + id +
                ", via='" + via + '\'' +
                ", città='" + citta + '\'' +
                '}';
    }
}
