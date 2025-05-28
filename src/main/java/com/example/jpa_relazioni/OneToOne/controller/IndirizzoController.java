package com.example.jpa_relazioni.OneToOne.controller;

import com.example.jpa_relazioni.OneToOne.entity.Indirizzo;
import com.example.jpa_relazioni.OneToOne.service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/indirizzi")
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;

    // crea un nuovo indirizzo:
    @PostMapping("/create-indirizzo/")
    public ResponseEntity<Indirizzo> addIndirizzo(@RequestBody Indirizzo indirizzo) {
        Indirizzo indirizzoToAdd = indirizzoService.addIndirizzo(indirizzo);
        return ResponseEntity.ok(indirizzoToAdd);
    }

    // Ottieni tutti gli indirizzi:
    @GetMapping("/find-indirizzi")
    public ResponseEntity<List<Indirizzo>> getIndirizzi() {
        List<Indirizzo> indirizziToFind = indirizzoService.getIndirizzi();
        return ResponseEntity.ok(indirizziToFind);
    }

    // Cancella un indirizzo esistente:
    @DeleteMapping("/delete-indirizzo/{id}")
    public ResponseEntity<Optional<Indirizzo>> deleteIndirizzo(@PathVariable Long id) {
        Optional<Indirizzo> indirizzoToDelete = indirizzoService.deleteIndirizzo(id);

        if (indirizzoToDelete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(indirizzoToDelete);
    }

    // modifica un indirizzo esistente:
    @PutMapping("/update-indirizzo/{id}")
    public ResponseEntity<Optional<Indirizzo>> updateIndirizzo(@PathVariable Long id, @RequestBody Indirizzo indirizzoDetails) {
        Optional<Indirizzo> indirizzoToUpdate = indirizzoService.updateIndirizzo(id, indirizzoDetails);

        if (indirizzoToUpdate.isPresent()) {
            return ResponseEntity.ok(indirizzoToUpdate);
        }
        return ResponseEntity.notFound().build();
    }
}
