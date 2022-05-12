package nl.workingtalentapp.library.service;

import nl.workingtalentapp.library.repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.UserHistory;

@Service
public class UserHistoryService {
	@Autowired
    UserHistoryRepository uhr;
	
	public void proberen() {
		UserHistory uh = new UserHistory();
		uhr.save(uh);
	}

	public Iterable<UserHistory> userhistory() {		
		return uhr.findAll();
	}
	
}
