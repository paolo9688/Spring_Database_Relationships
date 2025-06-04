package com.example.jpa_relazioni.ManyToMany.controller;

import com.example.jpa_relazioni.ManyToMany.entity.StudenteDevelhope;
import com.example.jpa_relazioni.ManyToMany.service.StudenteDevelhopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studenti-dev")
public class StudenteDevelhopeController {

    @Autowired
    private StudenteDevelhopeService studenteDevelhopeService;

    // crea un nuovo studente:
    @PostMapping("/create-studente")
    public ResponseEntity<StudenteDevelhope> addStudente(@RequestBody StudenteDevelhope studenteDevelhope) {
        StudenteDevelhope studenteToAdd = studenteDevelhopeService.addStudente(studenteDevelhope);
        return ResponseEntity.ok(studenteToAdd);
    }

    // ritorna uno studente per id:
    @GetMapping("/find-studente/{id}")
    public ResponseEntity<Optional<StudenteDevelhope>> getStudenteById(@PathVariable Long id) {
        Optional<StudenteDevelhope> studenteOptional = studenteDevelhopeService.getStudenteById(id);

        if (studenteOptional.isPresent()) {
            return ResponseEntity.ok(studenteOptional);
        }
        return ResponseEntity.notFound().build();
    }

    // ritorna la lista di tutti gli studenti:
    @GetMapping("/find-studenti")
    public ResponseEntity<List<StudenteDevelhope>> getStudenti() {
        List<StudenteDevelhope> studentiDevelhope = studenteDevelhopeService.getStudenti();
        return ResponseEntity.ok(studentiDevelhope);
    }

    // aggiorna uno studente esistente:
    /*
    * Grazie all'annotazione @ResponseStatus sulla ResourceNotFoundException,
    * il controller può essere semplificato notevolmente.
    * Non abbiamo più bisogno di un if/else per controllare il valore di ritorno null,
    * Spring si occuperà di mappare l'eccezione allo status HTTP 404.
    */
    @PutMapping("/update-studente/{id}")
    public ResponseEntity<StudenteDevelhope> updateStudente(@PathVariable Long id,
                                                            @RequestBody StudenteDevelhope studente) {
        StudenteDevelhope updatedStudente = studenteDevelhopeService.updateStudente(id, studente);
        return new ResponseEntity<>(updatedStudente, HttpStatus.OK);
    }

    // cancella uno studente per id (cancellazione fisica):
    @DeleteMapping("/delete-studente/{id}")
    public ResponseEntity<String> deleteStudente(@PathVariable Long id) {
        boolean deleted = studenteDevelhopeService.deleteStudente(id);
        if (deleted) {
            return new ResponseEntity<>("Studente con ID " + id + " cancellato con successo.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Studente con ID " + id + " non trovato.", HttpStatus.NOT_FOUND);
    }
}
