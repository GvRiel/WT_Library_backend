package nl.workingtalentapp.library.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.StatusHistorie;

@Service
public class StatusHistoryService {
	@Autowired
	StatusHistoryRepository shr;
	
	public void proberen() {
		
		StatusHistorie sh = new StatusHistorie();
		sh.setStatus_after("available");
		shr.save(sh);
		
	}
}
