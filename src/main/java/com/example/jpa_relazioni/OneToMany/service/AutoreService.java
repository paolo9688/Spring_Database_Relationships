package com.example.jpa_relazioni.OneToMany.service;

import com.example.jpa_relazioni.OneToMany.entity.Autore;
import com.example.jpa_relazioni.OneToMany.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    // crea un nuovo autore:
    public Autore addAutore(Autore autore) {
        return autoreRepository.save(autore);
    }

    // ritorna la lista di tutti gli autori:
    public List<Autore> getAutori() {
        return autoreRepository.findAll();
    }
}
