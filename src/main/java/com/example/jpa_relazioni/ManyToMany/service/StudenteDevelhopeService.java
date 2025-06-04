package com.example.jpa_relazioni.ManyToMany.service;

import com.example.jpa_relazioni.ManyToMany.entity.Corso;
import com.example.jpa_relazioni.ManyToMany.entity.StudenteDevelhope;
import com.example.jpa_relazioni.ManyToMany.exception.ResourceNotFoundException;
import com.example.jpa_relazioni.ManyToMany.repository.StudenteDevelhopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteDevelhopeService {

    @Autowired
    private StudenteDevelhopeRepository studenteDevelhopeRepository;

    // crea un nuovo stuente:
    public StudenteDevelhope addStudente(StudenteDevelhope studenteDevelhope) {
        return studenteDevelhopeRepository.save(studenteDevelhope);
    }

    // ritorna uno studente per id:
    public Optional<StudenteDevelhope> getStudenteById(Long id) {
        return studenteDevelhopeRepository.findById(id);
    }

    // ritorna la lista di tutti gli studenti:
    public List<StudenteDevelhope> getStudenti() {
        return studenteDevelhopeRepository.findAll();
    }

    // aggiorna uno studente esistente (da testare):
    public StudenteDevelhope updateStudente(Long id, StudenteDevelhope studenteDetails) {
        Optional<StudenteDevelhope> studenteOptional = studenteDevelhopeRepository.findById(id);
        if (studenteOptional.isPresent()) {
            StudenteDevelhope existingStudente = studenteOptional.get();
            existingStudente.setNome(studenteDetails.getNome());
            existingStudente.setCorsi(studenteDetails.getCorsi());
            return studenteDevelhopeRepository.save(existingStudente);
        } else {
            throw new ResourceNotFoundException("Studente con ID " + id + " non trovato.");
        }
    }

    // cancella uno studente per id:
    public boolean deleteStudente(Long id) {
        if (studenteDevelhopeRepository.existsById(id)) {
            studenteDevelhopeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
