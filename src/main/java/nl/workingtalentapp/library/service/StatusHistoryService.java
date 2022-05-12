package nl.workingtalentapp.library.service;

import nl.workingtalentapp.library.repository.StatusHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.StatusHistory;

@Service
public class StatusHistoryService {
	@Autowired
    StatusHistoryRepository shr;
	
	public void proberen() {
		
		StatusHistory sh = new StatusHistory();
		sh.setStatus_after("available");
		shr.save(sh);
	}
	
	public Iterable<StatusHistory> statushistory() {		
		return shr.findAll();
	}
	
}

