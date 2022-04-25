package nl.workingtalentapp.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.persistance.StatusHistoryService;

@RestController
public class StatusHistoryEndpoint {

	@Autowired
	StatusHistoryService shs;
	
	@GetMapping("/nieuwestatushistory")
	public String eersteStart() {
		
		shs.proberen();
		
		return "Hij werkt!";
	}
		
}
