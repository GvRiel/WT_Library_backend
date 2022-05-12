package nl.workingtalentapp.library.endpoints;

import nl.workingtalentapp.library.domein.Boek;
import nl.workingtalentapp.library.service.BoekService;
import nl.workingtalentapp.library.domein.Exemplaar;
import nl.workingtalentapp.library.service.ExemplaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/boek")
public class BoekResource {

    @Autowired
    ExemplaarService es;

    private final BoekService boekService;

    public BoekResource(BoekService boekService) {
        this.boekService = boekService;
    }

    @GetMapping("/boekenlijst")
    public ResponseEntity<List<Boek>> getAllBoek () {
        List<Boek> boeken = boekService.findAllBoek();
        return new ResponseEntity<>(boeken, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Boek> getBoekById (@PathVariable("id") Long id) {
        Boek boek = boekService.findBoek(id);
        return new ResponseEntity<>(boek, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Boek> addBoek(@RequestBody Boek boek) {
        Boek newBoek = boekService.addBoek(boek);
        int nCopies = newBoek.getCopies();
        for (int i = 0; i < nCopies; i++) {
            Exemplaar exemplaar = new Exemplaar("beschikbaar", true, newBoek );
            Exemplaar newExemplaar = es.addExemplaar(exemplaar);
        }
        return new ResponseEntity<>(newBoek, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Boek> updateBoek(@RequestBody Boek boek) {
        Boek oldbook = boekService.findBoek(boek.getId());
        int hoeveelheid = boek.getCopies() - oldbook.getCopies();
        Boek updateBoek = boekService.updateBoek(boek);
        for (int i = 0; i < hoeveelheid; i++) {
            Exemplaar exemplaar = new Exemplaar("beschikbaar", true, updateBoek );
            Exemplaar newExemplaar = es.addExemplaar(exemplaar);
        }
        return new ResponseEntity<>(updateBoek, HttpStatus.OK);
    }
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoek(@PathVariable("id") Long id) {
        Boek boek = boekService.findBoek(id);
        for (Exemplaar exemplaar:boek.getExemplaren()) {
            es.deleteExemplaar(exemplaar.getId());
        }
        boekService.deleteBoek(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
