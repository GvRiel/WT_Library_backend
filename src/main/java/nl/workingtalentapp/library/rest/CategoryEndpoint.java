package nl.workingtalentapp.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

