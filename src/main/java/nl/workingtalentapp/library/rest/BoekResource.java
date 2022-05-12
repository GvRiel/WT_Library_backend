package nl.workingtalentapp.library.rest;

import jdk.javadoc.doclet.Reporter;
import nl.workingtalentapp.library.domein.Boek;
import nl.workingtalentapp.library.persistance.BoekService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/boek")
public class BoekResource {

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
        return new ResponseEntity<>(newBoek, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Boek> updateBoek(@RequestBody Boek boek) {
        Boek updateBoek = boekService.updateBoek(boek);
        return new ResponseEntity<>(updateBoek, HttpStatus.OK);
    }
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBoek(@PathVariable("id") Long id) {
        boekService.deleteBoek(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
