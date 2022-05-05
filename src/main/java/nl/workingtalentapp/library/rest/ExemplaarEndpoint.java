package nl.workingtalentapp.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.Exemplaar;
import nl.workingtalentapp.library.persistance.ExemplaarService;

@RestController
//@RequestMapping("/exemplaar")
public class ExemplaarEndpoint {

	@Autowired
	ExemplaarService es;
	
	@GetMapping("/nieuwexemplaar")
	public String eersteStart() {
		es.nieuwExemplaarOpslaan();
		return "Hij doet het";
	}
	
//	@GetMapping("/exemplaren")
//	public Iterable<Exemplaar> exemplaren() {
//		return es.alleExemplaren();
//		
//	}
	
	@GetMapping("/testGijs/{voornaam}")
	public void testje(@PathVariable("voornaam") String voornaam) {
		System.out.println(">>" + voornaam);
	}
		
	@PostMapping("/testpostGijs/{achternaam}")
	public void testpost(@RequestBody Exemplaar tes, @PathVariable String achternaam) {
		System.out.println("van de body " + tes.getState());
		System.out.println("van de path " + achternaam);
		
	}
}