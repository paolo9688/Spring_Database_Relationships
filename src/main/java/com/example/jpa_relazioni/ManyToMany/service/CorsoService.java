package com.example.jpa_relazioni.ManyToMany.service;

import com.example.jpa_relazioni.ManyToMany.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorsoService {

    @Autowired
    private CorsoRepository corsoRepository;
}
