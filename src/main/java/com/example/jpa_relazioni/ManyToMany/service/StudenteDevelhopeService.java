package com.example.jpa_relazioni.ManyToMany.service;

import com.example.jpa_relazioni.ManyToMany.repository.StudenteDevelhopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudenteDevelhopeService {

    @Autowired
    private StudenteDevelhopeRepository studenteDevelhopeRepository;
}
