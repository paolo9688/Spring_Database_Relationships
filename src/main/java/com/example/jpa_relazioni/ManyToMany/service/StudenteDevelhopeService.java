package com.example.jpa_relazioni.ManyToMany.service;

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

    // ritorna uno studente specifico per id:
    public Optional<StudenteDevelhope> getStudenteById(Long id) {
        return studenteDevelhopeRepository.findById(id);
    }

    // ritorna la lista di tutti gli studenti:
    public List<StudenteDevelhope> getStudenti() {
        return studenteDevelhopeRepository.findAll();
    }

    // aggiorna uno studente esistente:
    public Optional<StudenteDevelhope> updateStudente(Long id, StudenteDevelhope studenteDetails) {
        Optional<StudenteDevelhope> studenteOptional = studenteDevelhopeRepository.findById(id);

        if (studenteOptional.isPresent()) {
            studenteOptional.get().setNome(studenteDetails.getNome());
            // studenteOptional.get().setCorsi(studenteDetails.getCorsi());
            StudenteDevelhope savedstudente = studenteDevelhopeRepository.save(studenteOptional.get());
            return Optional.of(savedstudente);
        } else {
            return Optional.empty();
        }
    }

    /*
    public StudenteDevelhope updateStudente(Long id, StudenteDevelhope updatedStudente) {
        // Cerca lo studente per ID. Restituisce un Optional.
        Optional<StudenteDevelhope> existingStudenteOptional = studenteDevelhopeRepository.findById(id);

        // Verifica se l'Optional contiene un valore (cioè, lo studente è stato trovato).
        if (existingStudenteOptional.isPresent()) {
            StudenteDevelhope existingStudente = existingStudenteOptional.get(); // Ottieni lo studente dall'Optional

            // Aggiorna solo i campi che desideri modificare
            existingStudente.setNome(updatedStudente.getNome());
            // Se vuoi gestire anche l'aggiornamento della lista dei corsi, puoi farlo qui:
            // existingStudente.setCorsi(updatedStudente.getCorsi());

            // Salva lo studente aggiornato nel database
            return studenteDevelhopeRepository.save(existingStudente);
        } else {
            // Se lo studente non viene trovato, restituisci null
            return null;
        }
    }
    */

    // cancella uno studente per id:
    public boolean deleteStudente(Long id) {
        if (studenteDevelhopeRepository.existsById(id)) {
            studenteDevelhopeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
