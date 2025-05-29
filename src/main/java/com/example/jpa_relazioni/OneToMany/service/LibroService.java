package com.example.jpa_relazioni.OneToMany.service;

import com.example.jpa_relazioni.OneToMany.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
}
