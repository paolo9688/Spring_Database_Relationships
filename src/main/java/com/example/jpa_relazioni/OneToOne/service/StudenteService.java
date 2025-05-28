package com.example.jpa_relazioni.OneToOne.service;

import com.example.jpa_relazioni.OneToOne.entity.Studente;
import com.example.jpa_relazioni.OneToOne.repository.IndirizzoRepository;
import com.example.jpa_relazioni.OneToOne.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    // crea un nuovo studente:
    public Studente addStudente(Studente studente) {
        return studenteRepository.save(studente);
    }

    // ottieni una lista di tutti gli studenti:
    public List<Studente> getAllStudenti() {
        return studenteRepository.findAll();
    }

    // ottieni uno studente per id:
    public Optional<Studente> getStudenteById(Long id) {
        return studenteRepository.findById(id);
    }

    // aggiorna uno studente per id:
    public Optional<Studente> updateStudenteById(Long id, Studente studenteDetails) {
        Optional<Studente> studenteOptional = studenteRepository.findById(id);

        if (studenteOptional.isPresent()) {
            studenteOptional.get().setNome(studenteDetails.getNome());
            studenteOptional.get().setIndirizzo(studenteDetails.getIndirizzo());
            return studenteOptional;
        } else {
            return Optional.empty();
        }
    }

    // cancella uno studente dal database:
    public Optional<Studente> deleteStudente(Long id) {
        Optional<Studente> studenteOptional = studenteRepository.findById(id);

        if (studenteOptional.isPresent()) {
            studenteRepository.deleteById(id);
            return studenteOptional;
        } else {
            return Optional.empty();
        }
    }
}
