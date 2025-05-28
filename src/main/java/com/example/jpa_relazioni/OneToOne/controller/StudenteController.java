package com.example.jpa_relazioni.OneToOne.controller;

import com.example.jpa_relazioni.OneToOne.entity.Studente;
import com.example.jpa_relazioni.OneToOne.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    // crea un nuovo studente:
    @PostMapping("/create-studente")
    public ResponseEntity<Studente> addStudente(@RequestBody Studente studente) {
        Studente studenteToAdd = studenteService.addStudente(studente);
        return ResponseEntity.ok(studenteToAdd);
    }

    // ottieni una lista di tutti gli studenti:
    @GetMapping("/find-studenti")
    public ResponseEntity<List<Studente>> getStudenti() {
        List<Studente> studentiToFind = studenteService.getAllStudenti();
        return ResponseEntity.ok(studentiToFind);
    }

    // ottieni uno studente per id:
    @GetMapping("/find-studente/{id}")
    public ResponseEntity<Optional<Studente>> getStudenteById(@PathVariable Long id) {
        Optional<Studente> studenteOptional = studenteService.getStudenteById(id);

        if (studenteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studenteOptional);
    }

    // aggiorna uno studente per id:
    @PutMapping("/update-studente/{id}")
    public ResponseEntity<Optional<Studente>> updateStudenteById(@PathVariable Long id,
                                                                 @RequestParam Studente studente) {
        Optional<Studente> studenteOptional = studenteService.getStudenteById(id);

        if (studenteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studenteOptional);
    }

    // cancella uno studente dal database:
    @DeleteMapping("/delete-studente/{id}")
    public ResponseEntity<Optional<Studente>> deleteStudente(@PathVariable Long id) {
        Optional<Studente> studenteToDelete = studenteService.deleteStudente(id);

        if (studenteToDelete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studenteToDelete);
    }
}
