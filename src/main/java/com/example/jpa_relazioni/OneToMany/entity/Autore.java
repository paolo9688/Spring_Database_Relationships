package com.example.jpa_relazioni.OneToMany.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Autore() {}

    public Autore(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Autore autore = (Autore) o;
        return Objects.equals(id, autore.id) && Objects.equals(nome, autore.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}