package nl.workingtalentapp.library.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.UserHistory;
import nl.workingtalentapp.library.service.UserHistoryService;

@RestController
public class UserHistoryEndpoint {
	@Autowired
	UserHistoryService uhs;
	
	@GetMapping("/nieuweuserhistory")
	public String eersteStart() {
		uhs.proberen();
		
		return "Hij doet het";
	}
	
	@GetMapping("/userhistory")
	public Iterable<UserHistory> userhistory() {
		return uhs.userhistory();
	}
	@GetMapping("/testvarfelix/{voornaam}")
	public void testje(@PathVariable("voornaam") String voornaam) {
		System.out.println(">>"+voornaam);
	}
	@PostMapping("/testpostfelix/{achternaam}")
	public void testpost(@RequestBody UserHistory uh, @PathVariable String achternaam) {
		System.out.println( "van de body: "+uh.getStatus() );
		System.out.println( "van de path: "+achternaam );
	}
	
}
