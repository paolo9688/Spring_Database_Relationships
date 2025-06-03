package com.example.jpa_relazioni.ManyToMany.service;

import com.example.jpa_relazioni.ManyToMany.entity.StudenteDevelhope;
import com.example.jpa_relazioni.ManyToMany.repository.StudenteDevelhopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteDevelhopeService {

    @Autowired
    private StudenteDevelhopeRepository studenteDevelhopeRepository;

    // crea un nuovo stuente:
    public StudenteDevelhope addStudente(StudenteDevelhope studenteDevelhope) {
        return studenteDevelhopeRepository.save(studenteDevelhope);
    }

    // ritorna la lista di tutti gli studenti:
    public List<StudenteDevelhope> getStudenti() {
        return studenteDevelhopeRepository.findAll();
    }
}
