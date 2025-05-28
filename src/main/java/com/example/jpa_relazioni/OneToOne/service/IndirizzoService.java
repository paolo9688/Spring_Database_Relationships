package com.example.jpa_relazioni.OneToOne.service;

import com.example.jpa_relazioni.OneToOne.entity.Indirizzo;
import com.example.jpa_relazioni.OneToOne.repository.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndirizzoService {

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    // crea un nuovo indirizzo:
    public Indirizzo addIndirizzo(Indirizzo indirizzo) {
        return indirizzoRepository.save(indirizzo);
    }

    // ritorna tutti gli indirizzi:
    public List<Indirizzo> getIndirizzi() {
        return indirizzoRepository.findAll();
    }

    // cancella un indirizzo:
    public Optional<Indirizzo> deleteIndirizzo(Long id) {
        Optional<Indirizzo> indirizzoOptional = indirizzoRepository.findById(id);

        if (indirizzoOptional.isPresent()) {
            indirizzoRepository.deleteById(id);
            return indirizzoOptional;
        } else {
            return Optional.empty();
        }
    }

    // modifica un indirizzo:
    public Optional<Indirizzo> updateIndirizzo(Long id, Indirizzo indirizzoDetails) {
        Optional<Indirizzo> indirizzoOptional = indirizzoRepository.findById(id);

        if (indirizzoOptional.isPresent()) {
            indirizzoOptional.get().setVia(indirizzoDetails.getVia());
            indirizzoOptional.get().setCitta(indirizzoDetails.getCitta());
            Indirizzo indirizzo = indirizzoRepository.save(indirizzoOptional.get());
            return Optional.of(indirizzo);
        } else {
            return Optional.empty();
        }
    }
}
