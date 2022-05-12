package nl.workingtalentapp.library.service;

import nl.workingtalentapp.library.repository.BoekRepo;
import nl.workingtalentapp.library.domein.Boek;
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

    public Boek addBoek(Boek boek) {
        boek.setBookCode(UUID.randomUUID().toString());
        boek.setAvailable(boek.getCopies());
        return boekRepo.save(boek);
    }

    public List<Boek> findAllBoek() {
        return boekRepo.findAll();
    }

    public Boek updateBoek(Boek boek) {
        return boekRepo.save(boek);
    }

    public Boek findBoek(long id) {
        return boekRepo.findBoekById(id).orElseThrow(() -> new BoeknotFoundException("Boek met id: " + id + " was niet gevonden"));
    }

    public void deleteBoek(Long id) {
        boekRepo.deleteBoekById(id);
    }

}
