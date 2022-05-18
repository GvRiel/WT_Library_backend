package nl.workingtalentapp.library.service;

import nl.workingtalentapp.library.repository.BoekRepo;
import nl.workingtalentapp.library.domein.Boek;
import nl.workingtalentapp.library.domein.Exemplaar;
import nl.workingtalentapp.library.exception.BoeknotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BoekService {
    private final BoekRepo boekRepo;

    @Autowired
    public BoekService(BoekRepo boekRepo) {
        this.boekRepo = boekRepo;
    }

    @Autowired
    ExemplaarService es;
    
    public Boek addBoek(Boek boek) {
        boek.setBookCode(UUID.randomUUID().toString());
        boek.setAvailable(boek.getCopies());
        return boekRepo.save(boek);
    }

    public List<Boek> findAllBoek() {
        return boekRepo.findAll();
    }

    public Boek updateBoek(Boek boek) {
        Boek oldbook = findBoek(boek.getId());
        int hoeveelheid = boek.getCopies() - oldbook.getCopies();
        if (hoeveelheid < 0) {
        	boek.setCopies(oldbook.getCopies());
        }
        if (hoeveelheid > 0) {
	        if (oldbook.getAvailable() == boek.getAvailable()) {
	        	boek.setAvailable(boek.getAvailable() + hoeveelheid);
	        }
	        for (int i = 0; i < hoeveelheid; i++) {
	            Exemplaar exemplaar = new Exemplaar("beschikbaar", true, boek );
	            es.addExemplaar(exemplaar);
	        }
        }
        return boekRepo.save(boek);
    }

    public Boek findBoek(long id) {
        return boekRepo.findBoekById(id).orElseThrow(() -> new BoeknotFoundException("Boek met id: " + id + " was niet gevonden"));
    }

    public void deleteBoek(Long id) {
        boekRepo.deleteBoekById(id);
    }

}
