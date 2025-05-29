package com.example.jpa_relazioni.OneToMany.controller;

import com.example.jpa_relazioni.OneToMany.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;
}
