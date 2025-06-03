package com.example.jpa_relazioni.ManyToMany.controller;

import com.example.jpa_relazioni.ManyToMany.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;
}
