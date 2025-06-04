package com.example.jpa_relazioni.ManyToMany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "corsi")
    @JsonIgnore
    private List<StudenteDevelhope> studenti;

    public Corso() {}

    public Corso(Long id, String nome, List<StudenteDevelhope> studenti) {
        this.id = id;
        this.nome = nome;
        this.studenti = studenti;
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

    public List<StudenteDevelhope> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<StudenteDevelhope> studenti) {
        this.studenti = studenti;
    }
}
