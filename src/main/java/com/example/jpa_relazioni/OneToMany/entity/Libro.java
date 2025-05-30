package com.example.jpa_relazioni.OneToMany.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    private List<Autore> autori;

    public Libro() {}

    public Libro(Long id, String titolo, List<Autore> autori) {
        this.id = id;
        this.titolo = titolo;
        this.autori = autori;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Autore> getAutori() {
        return autori;
    }

    public void setAutori(List<Autore> autori) {
        this.autori = autori;
    }

    // controlla che un autore sia già presente nella lista autori:
    public boolean checkAutore(Autore autore) {
        return autori.contains(autore);
    }

    // aggiungi un autore alla lista autori:
    public void addAutore(Autore autore) {
        if (!checkAutore(autore)) {
            autori.add(autore);
        }
    }

    // rimuovi un autore dalla lista autori:
    public void removeAutore(Autore autore) {
        if (checkAutore(autore)) {
            autori.remove(autore);
        }
    }
}