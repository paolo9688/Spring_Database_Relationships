package com.example.jpa_relazioni.OneToMany.service;

import com.example.jpa_relazioni.OneToMany.entity.Autore;
import com.example.jpa_relazioni.OneToMany.entity.Libro;
import com.example.jpa_relazioni.OneToMany.repository.AutoreRepository;
import com.example.jpa_relazioni.OneToMany.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    // crea un nuovo libro:
    /*public Libro addLibro(Libro libro) {
        return libroRepository.save(libro);
    }*/

    // crea un nuovo libro:
    @Transactional
    public Libro addLibro(Libro libro) {
        List<Autore> autoriDaAssociare = new ArrayList<>();
        if (libro.getAutori() != null) {
            for (Autore autore : libro.getAutori()) {
                if (autore.getId() != null) {
                    Optional<Autore> autoreTrovato = autoreRepository.findById(autore.getId());
                    if (autoreTrovato.isPresent()) {
                        autoriDaAssociare.add(autoreTrovato.get());
                    } else {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autore con ID " + autore.getId() + " non trovato");
                    }
                }
            }
        }
        libro.setAutori(autoriDaAssociare);
        return libroRepository.save(libro);
    }

    // aggiungi un autore ad un libro dopo aver creato il libro:
    public Optional<Libro> aggiungiAutoreAlLibro(Long libroId, Long autoreId) {
        Optional<Libro> optionalLibro = libroRepository.findById(libroId);
        Optional<Autore> optionalAutore = autoreRepository.findById(autoreId);

        if (optionalLibro.isPresent() && optionalAutore.isPresent()) {
            Libro libro = optionalLibro.get();
            Autore autore = optionalAutore.get();

            libro.addAutore(autore);
            return Optional.of(libroRepository.save(libro));
        }
        return Optional.empty();
    }

    // rimuovi un autore da un libro dopo aver creato il libro:
    public Optional<Libro> rimuoviAutoreAlLibro(Long libroId, Long autoreId) {
        Optional<Libro> optionalLibro = libroRepository.findById(libroId);
        Optional<Autore> optionalAutore = autoreRepository.findById(autoreId);

        if (optionalLibro.isPresent() && optionalAutore.isPresent()) {
            Libro libro = optionalLibro.get();
            Autore autore = optionalAutore.get();

            libro.removeAutore(autore);
            return Optional.of(libroRepository.save(libro));
        }
        return Optional.empty();
    }
}
