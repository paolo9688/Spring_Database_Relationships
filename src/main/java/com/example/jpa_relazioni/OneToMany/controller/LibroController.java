package com.example.jpa_relazioni.OneToMany.controller;

import com.example.jpa_relazioni.OneToMany.entity.Libro;
import com.example.jpa_relazioni.OneToMany.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
