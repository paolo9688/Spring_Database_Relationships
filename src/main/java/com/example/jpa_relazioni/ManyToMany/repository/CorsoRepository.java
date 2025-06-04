package com.example.jpa_relazioni.ManyToMany.repository;

import com.example.jpa_relazioni.ManyToMany.entity.Corso;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
    // metodo per trovare tutti i corsi non cancellati:
    List<Corso> findByDeletedFalse();

    // metodo per trovare un corso specifico per ID solo se non è cancellato
    Optional<Corso> findByIdAndDeletedFalse(Long id);

    // metodo per la cancellazione logica: imposta il campo 'deleted' a true
    @Modifying
    @Transactional // Aggiungi @Transactional per le operazioni di modifica
    @Query("UPDATE Corso c SET c.deleted = true WHERE c.id = :id")
    void softDeleteById(@Param("id") Long id);

    // metodo per "recuperare" un corso cancellato logicamente
    @Modifying
    @Transactional
    @Query("UPDATE Corso c SET c.deleted = false WHERE c.id = :id")
    void restoreById(@Param("id") Long id);
}
