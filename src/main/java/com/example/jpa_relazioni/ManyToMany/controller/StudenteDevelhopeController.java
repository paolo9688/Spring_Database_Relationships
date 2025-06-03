package com.example.jpa_relazioni.ManyToMany.controller;

import com.example.jpa_relazioni.ManyToMany.service.StudenteDevelhopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/studenti-dev")
public class StudenteDevelhopeController {

    @Autowired
    private StudenteDevelhopeService studenteDevelhopeService;
}
