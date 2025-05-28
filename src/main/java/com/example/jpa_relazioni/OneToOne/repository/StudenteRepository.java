package com.example.jpa_relazioni.OneToOne.repository;

import com.example.jpa_relazioni.OneToOne.entity.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Long> {

}
