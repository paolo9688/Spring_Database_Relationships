package com.example.jpa_relazioni.ManyToMany.service;

import com.example.jpa_relazioni.ManyToMany.entity.Corso;
import com.example.jpa_relazioni.ManyToMany.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorsoService {

    @Autowired
    private CorsoRepository corsoRepository;

    // crea un nuovo corso:
    public Corso addCorso(Corso corso) {
        return corsoRepository.save(corso);
    }

    // ritorna la lista di tutti i corsi:
    public List<Corso> getCorsi() {
        return corsoRepository.findAll();
    }
}
