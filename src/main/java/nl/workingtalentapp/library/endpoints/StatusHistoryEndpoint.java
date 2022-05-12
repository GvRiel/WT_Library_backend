package nl.workingtalentapp.library.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.StatusHistory;
import nl.workingtalentapp.library.service.StatusHistoryService;

@RestController
public class StatusHistoryEndpoint {

	@Autowired
	StatusHistoryService shs;
	
	@GetMapping("/nieuwestatushistory")
	public String eersteStart() {
		
		shs.proberen();
		
		return "Hij werkt!";
	}
		
	@GetMapping("/statushistory")
	public Iterable<StatusHistory> statushistory() {
		return shs.statushistory();
	}
	
	@GetMapping("/testvarttako/{status_before}")
	public void testje(@PathVariable("status voor") String status_before) {
		System.out.println(">>"+status_before);
	}
	@PostMapping("/testposttako/{status_after}")
	public void testpost(@RequestBody StatusHistory sh, @PathVariable String status_after) {
		System.out.println( "van de body: "+sh.getStatus_after() );
		System.out.println( "van de path: "+ status_after );
	}
}
