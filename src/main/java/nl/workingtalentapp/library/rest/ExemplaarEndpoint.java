package nl.workingtalentapp.library.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.Exemplaar;
import nl.workingtalentapp.library.persistance.ExemplaarService;

@RestController
@RequestMapping("/exemplaar")
public class ExemplaarEndpoint {

	@Autowired
	ExemplaarService es;
	
	@GetMapping("/exemplaren/all")
    public ResponseEntity<List<Exemplaar>> getAllExemplaren () {
        List<Exemplaar> exemplaren = es.findAllExemplaren();
        return new ResponseEntity<>(exemplaren, HttpStatus.OK);
    }
	
	@GetMapping("/boekexemplaren/{bookCode}")
    public ResponseEntity<List<Exemplaar>> getBoekExemplaren (@PathVariable("bookCode") String bookCode) {
        List<Exemplaar> exemplaren = es.findExemplaarByBookCode(bookCode);
        return new ResponseEntity<>(exemplaren, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Exemplaar> getExemplaarById (@PathVariable("id") Long id) {
    	Exemplaar exemplaar = es.findExemplaarById(id);
        return new ResponseEntity<>(exemplaar, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Exemplaar> addExemplaar(@RequestBody Exemplaar exemplaar) {
    	Exemplaar newExemplaar = es.addExemplaar(exemplaar);
        return new ResponseEntity<>(newExemplaar, HttpStatus.CREATED);
    }
    
//    @PostMapping("/addlist")
//    public ResponseEntity<Exemplaar> addExemplaarList(@RequestBody int copies, Exemplaar exemplaar) {
//    	for (int i=0; i < copies; i++) {
//    		Exemplaar newExemplaar = es.addExemplaar(exemplaar);
//    		new ResponseEntity<>(newExemplaar, HttpStatus.CREATED);
//    	}
//    	return null;
//    }
    
    @PostMapping("/addlist")
    public ResponseEntity<Exemplaar> addExemplaarList(@RequestBody List<Exemplaar> exemplaren) {
    	for (Exemplaar exemplaar : exemplaren) {
    		Exemplaar newExemplaar = es.addExemplaar(exemplaar);
    		new ResponseEntity<>(newExemplaar, HttpStatus.CREATED);
    	}
    	return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Exemplaar> updateExemplaar(@RequestBody Exemplaar exemplaar) {
    	Exemplaar updateExemplaar = es.updateExemplaar(exemplaar);
        return new ResponseEntity<>(updateExemplaar, HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExemplaar(@PathVariable("id") Long id) {
        es.deleteExemplaar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	

}