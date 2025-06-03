package com.example.jpa_relazioni.ManyToMany.controller;

import com.example.jpa_relazioni.ManyToMany.entity.Corso;
import com.example.jpa_relazioni.ManyToMany.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // ritorna la lista di tutti i corsi:
    @GetMapping("/find-corsi")
    public ResponseEntity<List<Corso>> getCorsi() {
        List<Corso> corsoToFind = corsoService.getCorsi();
        return ResponseEntity.ok(corsoToFind);
    }
}
