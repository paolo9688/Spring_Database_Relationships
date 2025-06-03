package com.example.jpa_relazioni.ManyToMany.repository;

import com.example.jpa_relazioni.ManyToMany.entity.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {

}
