package com.example.jpa_relazioni.ManyToMany.controller;

import com.example.jpa_relazioni.ManyToMany.entity.Corso;
import com.example.jpa_relazioni.ManyToMany.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;

    // crea un nuovo corso:
    @PostMapping("/create-corso")
    public ResponseEntity<Corso> addCorso(@RequestBody Corso corso) {
        Corso corsoToAdd = corsoService.addCorso(corso);
        return ResponseEntity.ok(corsoToAdd);
    }

    // ritorna la lista di tutti i corsi non cancellati logicamente:
    @GetMapping("/find-corsi-not-deleted")
    public ResponseEntity<List<Corso>> getCorsiNotLogicalDeleted() {
        List<Corso> corsoToFind = corsoService.getCorsiNotLogicalDeleted();
        return ResponseEntity.ok(corsoToFind);
    }

    // ritorna la lista di tutti i corsi, compresi quelli cancellati logicamente:
    @GetMapping("/find-corsi")
    public ResponseEntity<List<Corso>> getCorsi() {
        List<Corso> corsoToFind = corsoService.getCorsi();
        return ResponseEntity.ok(corsoToFind);
    }

    // cancella un corso specifico per id:
    @DeleteMapping("/delete-corso/{id}")
    public ResponseEntity<Optional<Corso>> deleteCorso(@PathVariable Long id) {
        Optional<Corso> corsoToDelete = corsoService.deleteCorso(id);

        if (corsoToDelete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(corsoToDelete);
    }

    // cancella logicamente un corso per id:
    @DeleteMapping("/delete-corso-logic/{id}")
    public ResponseEntity<String> softDeleteCorso(@PathVariable Long id) {
        Optional<Corso> corsoOptional = corsoService.getCorsoById(id); // Controlla se il corso esiste e non è già deleted
        if (corsoOptional.isPresent()) {
            corsoService.softDeleteCorso(id);
            return new ResponseEntity<>("Corso con ID " + id + " cancellato logicamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Corso con ID " + id + " non trovato o già cancellato.", HttpStatus.NOT_FOUND);
    }

    // modifica un corso specifico:
    @PutMapping("/update-corso/{id}")
    public ResponseEntity<Optional<Corso>> updateCorso(@PathVariable Long id,
                                                       @RequestBody Corso corsoDetails) {
        Optional<Corso> corsoToUpdate = corsoService.updateCorso(id, corsoDetails);

        if (corsoToUpdate.isPresent()) {
            return ResponseEntity.ok(corsoToUpdate);
        }
        return ResponseEntity.notFound().build();
    }
}
