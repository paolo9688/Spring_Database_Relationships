package com.example.jpa_relazioni.OneToMany.controller;

import com.example.jpa_relazioni.OneToMany.entity.Autore;
import com.example.jpa_relazioni.OneToMany.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    // crea un nuovo autore:
    @PostMapping("/create-autore")
    public ResponseEntity<Autore> addAutore(@RequestBody Autore autore) {
        Autore autoreToAdd = autoreService.addAutore(autore);
        return ResponseEntity.ok(autoreToAdd);
    }

    // ritorna la lista di tutti gli autori:
    @GetMapping("/find-autori")
    public ResponseEntity<List<Autore>> getAutori() {
        List<Autore> autoreToFind = autoreService.getAutori();
        return ResponseEntity.ok(autoreToFind);
    }
}
