package com.example.jpa_relazioni.ManyToMany.controller;

import com.example.jpa_relazioni.ManyToMany.entity.StudenteDevelhope;
import com.example.jpa_relazioni.ManyToMany.service.StudenteDevelhopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studenti-dev")
public class StudenteDevelhopeController {

    @Autowired
    private StudenteDevelhopeService studenteDevelhopeService;

    // crea un nuovo studente:
    @PostMapping("/create-studente")
    public ResponseEntity<StudenteDevelhope> addStudente(@RequestBody StudenteDevelhope studenteDevelhope) {
        StudenteDevelhope studenteToAdd = studenteDevelhopeService.addStudente(studenteDevelhope);
        return ResponseEntity.ok(studenteToAdd);
    }

    // ritorna la lista di tutti gli studenti:
    @GetMapping("/find-studenti")
    public ResponseEntity<List<StudenteDevelhope>> getStudenti() {
        List<StudenteDevelhope> studenteToFind = studenteDevelhopeService.getStudenti();
        return ResponseEntity.ok(studenteToFind);
    }
}
