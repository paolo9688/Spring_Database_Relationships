package com.example.jpa_relazioni.OneToMany.service;

import com.example.jpa_relazioni.OneToMany.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;
}
