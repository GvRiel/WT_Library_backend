package nl.workingtalentapp.library.rest;

import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.persistance.UserHistoryService;

@RestController
public class UserHistoryEndpoint {
	@Autowired
	UserHistoryService uhs;
	
	@GetMapping("/nieuweuserhistory")
	public String eersteStart() {
		uhs.proberen();
		
		return "Hij doet het";
	}
}
