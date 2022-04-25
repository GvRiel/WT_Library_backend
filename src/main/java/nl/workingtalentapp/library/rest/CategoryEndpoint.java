package nl.workingtalentapp.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.Category;
import nl.workingtalentapp.library.persistance.CategoryService;

@RestController
public class CategoryEndpoint {
	
	@Autowired
	CategoryService cs;
	
	
	@GetMapping("/nieuwecategory")
	public String testCategory() {
		cs.proberen();
		
		return "Hij doet het!";
		}
	
	@GetMapping("/categories")
	public Iterable<Category> category() {
		return cs.category();
	}
	
	@GetMapping("/testvarsofieke/{voornaam}")
	public void testje(@PathVariable("voornaam") String voornaam) {
		System.out.println(">>"+voornaam);
	}	
	@PostMapping("/testpostsofieke/{catname}")
	public void testpost(@RequestBody Category cat, @PathVariable String catname) {
		System.out.println("van de body: " + cat.getCat_name() );
		System.out.println("van de path: " + catname);
		cs.slamaaropditding(cat);
	}	
	
			
}

