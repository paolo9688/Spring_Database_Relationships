package com.example.jpa_relazioni.OneToOne.controller;

import com.example.jpa_relazioni.OneToOne.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;
}
