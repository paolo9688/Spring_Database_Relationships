package com.example.jpa_relazioni.OneToOne.service;

import com.example.jpa_relazioni.OneToOne.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;
}
