package com.example.jpa_relazioni.OneToMany.repository;

import com.example.jpa_relazioni.OneToMany.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
