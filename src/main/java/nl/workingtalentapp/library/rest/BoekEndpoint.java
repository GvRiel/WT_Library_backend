package nl.workingtalentapp.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.Boek;
import nl.workingtalentapp.library.persistance.BoekService;

@RestController
public class BoekEndpoint {

	@Autowired
	BoekService test;
	
	@GetMapping("/nieuwboek")
	public String eersteStart() {
		test.proberen();
		
		return "Hij doet het";
	}
	
	@GetMapping("/boeken")
	public Iterable<Boek> boeken() {
		return test.boeken();
		
	}
}
