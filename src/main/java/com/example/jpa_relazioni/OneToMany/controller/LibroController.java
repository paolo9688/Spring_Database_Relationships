package com.example.jpa_relazioni.OneToMany.controller;

import com.example.jpa_relazioni.OneToMany.entity.Libro;
import com.example.jpa_relazioni.OneToMany.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/libri")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // crea un nuovo libro:
    @PostMapping("/create-libro")
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
        Libro libroToAdd = libroService.addLibro(libro);
        return ResponseEntity.ok(libroToAdd);
    }

    // aggiungi un autore ad un libro dopo aver creato il libro:
    @PutMapping("/add-autore")
    public ResponseEntity<Optional<Libro>> aggiungiAutoreAlLibro(@RequestParam Long libroId,
                                                                 @RequestParam Long autoreId) {
        Optional<Libro> libroToAdd = libroService.aggiungiAutoreAlLibro(libroId, autoreId);
        return ResponseEntity.ok(libroToAdd);
    }

    // rimuovi un autore da un libro dopo aver creato il libro:
    @PutMapping("/remove-autore")
    public ResponseEntity<Optional<Libro>> rimuoviAutoreAlLibro(@RequestParam Long libroId,
                                                                 @RequestParam Long autoreId) {
        Optional<Libro> libroToAdd = libroService.rimuoviAutoreAlLibro(libroId, autoreId);
        return ResponseEntity.ok(libroToAdd);
    }
}
