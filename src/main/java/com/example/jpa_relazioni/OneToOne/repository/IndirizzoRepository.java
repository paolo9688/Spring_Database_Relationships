package com.example.jpa_relazioni.OneToOne.repository;

import com.example.jpa_relazioni.OneToOne.entity.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long> {

}
