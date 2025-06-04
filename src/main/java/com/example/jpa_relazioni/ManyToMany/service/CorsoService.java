package com.example.jpa_relazioni.ManyToMany.service;

import com.example.jpa_relazioni.ManyToMany.entity.Corso;
import com.example.jpa_relazioni.ManyToMany.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorsoService {

    @Autowired
    private CorsoRepository corsoRepository;

    // crea un nuovo corso:
    public Corso addCorso(Corso corso) {
        return corsoRepository.save(corso);
    }

    // ritorna un corso per id:
    public Optional<Corso> getCorsoById(Long id) {
        Optional<Corso> corsoOptional = corsoRepository.findByIdAndDeletedFalse(id);

        if (corsoOptional.isPresent()) {
            corsoRepository.findById(id);
            return corsoOptional;
        } else {
            return Optional.empty();
        }
    }

    // ritorna la lista di tutti i corsi non cancellati logicamente:
    public List<Corso> getCorsiNotLogicalDeleted() {
        return corsoRepository.findByDeletedFalse();
    }

    // ritorna la lista di tutti i corsi, compresi quelli cancellati logicamente:
    public List<Corso> getCorsi() {
        return corsoRepository.findAll();
    }

    // cancella un corso specifico per id:
    public Optional<Corso> deleteCorso(Long id) {
        Optional<Corso> corsoOptional = corsoRepository.findById(id);

        if (corsoOptional.isPresent()) {
            corsoRepository.deleteById(id);
            return corsoOptional;
        } else {
            return Optional.empty();
        }
    }

    // modifica un corso specifico:
    public Optional<Corso> updateCorso(Long id, Corso corsoDetails) {
        Optional<Corso> corsoOptional = corsoRepository.findById(id);

        if (corsoOptional.isPresent()) {
            corsoOptional.get().setNome(corsoDetails.getNome());
            Corso indirizzo = corsoRepository.save(corsoOptional.get());
            return Optional.of(indirizzo);
        } else {
            return Optional.empty();
        }
    }

    // cancella logicamente un corso per id:
    public void softDeleteCorso(Long id) {
        corsoRepository.softDeleteById(id);
    }

    // metodo per il ripristino di un corso logicamente cancellato:
    public void restoreCorso(Long id) {
        corsoRepository.restoreById(id);
    }
}
