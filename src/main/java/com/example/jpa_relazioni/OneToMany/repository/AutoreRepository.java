package com.example.jpa_relazioni.OneToMany.repository;

import com.example.jpa_relazioni.OneToMany.entity.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<Autore, Long> {

}
