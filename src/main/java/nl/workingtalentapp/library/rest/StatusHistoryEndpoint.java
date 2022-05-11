package nl.workingtalentapp.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.StatusHistory;
import nl.workingtalentapp.library.persistance.StatusHistoryService;

import java.util.List;

@RestController
@RequestMapping("/statushistory")
public class StatusHistoryEndpoint {
	private final StatusHistoryService shService;
	
	public StatusHistoryEndpoint(StatusHistoryService shService) {
		this.shService = shService;
	}
	
	@GetMapping("/all") // return alle statushistories
	public ResponseEntity<List<StatusHistory>> getAllStatusHistories () {
		List<StatusHistory> statusUpdates = shService.findAllStatusHistory(); 
		return new ResponseEntity<>(statusUpdates, HttpStatus.OK);
	}

	@GetMapping("/find/{id}") // return statushistory by id
	public ResponseEntity<StatusHistory> getStatusHistoryById (@PathVariable("id") Long id) {
		StatusHistory statusUpdate = shService.findStatusHistoryId(id); 
		return new ResponseEntity<>(statusUpdate, HttpStatus.OK);
	}

	@GetMapping("/find/{user_id}") // return statushistory for user with user_id
	public ResponseEntity<List<StatusHistory>> getStatusHistoryByUser (@PathVariable("user_id") Long user_id) {
		List<StatusHistory> statusUpdates = shService.findStatusHistoryUser(user_id); 
		return new ResponseEntity<>(statusUpdates, HttpStatus.OK);
	}	

	@GetMapping("/find/{copy_id}") // return statushistory for copy with copy_id
	public ResponseEntity<List<StatusHistory>> getStatusHistoryByCopy (@PathVariable("copy_id") Long copy_id) {
		List<StatusHistory> statusUpdates = shService.findStatusHistoryCopy(); 
		return new ResponseEntity<>(statusUpdates, HttpStatus.OK);
	}	
	
	@GetMapping("/find/{book_id}") // return statushistory for book with book_id
	public ResponseEntity<List<StatusHistory>> getStatusHistoryByBook (@PathVariable("book_id") Long book_id) {
		List<StatusHistory> statusUpdates = shService.findStatusHistoryBook(book_id); 
		return new ResponseEntity<>(statusUpdates, HttpStatus.OK);
	}	
	
	@PostMapping("/add")
	public ResponseEntity<StatusHistory> addStatusHistory (@RequestBody StatusHistory newStatusHistory) {
		return shService.save(newStatusHistory);
	}
//	
	
//	@Autowired
//	StatusHistoryService shs;
//	
//	@GetMapping("/nieuwestatushistory")
//	public String eersteStart() {
//		
//		shs.proberen();
//		
//		return "Hij werkt!";
//	}
//		
//	@GetMapping("/statushistory")
//	public Iterable<StatusHistory> statushistory() {
//		return shs.statushistory();
//	}
//	
//	@GetMapping("/testvarttako/{status_before}")
//	public void testje(@PathVariable("status voor") String status_before) {
//		System.out.println(">>"+status_before);
//	}
//	@PostMapping("/testposttako/{status_after}")
//	public void testpost(@RequestBody StatusHistory sh, @PathVariable String status_after) {
//		System.out.println( "van de body: "+sh.getStatus() );
//		System.out.println( "van de path: "+ status_after );
//	}
}
