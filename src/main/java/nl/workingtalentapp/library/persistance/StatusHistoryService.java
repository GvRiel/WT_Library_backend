package nl.workingtalentapp.library.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.StatusHistory;
import nl.workingtalentapp.library.persistance.StatusHistoryRepository;

@Service
public class StatusHistoryService {
	public final StatusHistoryRepository shRepo;
	
	@Autowired
	public StatusHistoryService(StatusHistoryRepository shRepo) {
		this.shRepo = shRepo;
	}
	
	public StatusHistory addStatusUpdate(StatusHistory statusUpdate) {
		return shRepo.save(statusUpdate);
	}
	
	public List<StatusHistory> findAllStatusHistory() {
		return shRepo.findAll();
	}
	
	public StatusHistory findStatusHistoryId(Long id) {
		return shRepo.findStatusHistoryById(id);
	}

	public List<StatusHistory> findStatusHistoryUser(Long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StatusHistory> findStatusHistoryCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StatusHistory> findStatusHistoryBook(Long book_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<StatusHistory> save(StatusHistory newStatusHistory) {
		// TODO Auto-generated method stub
		return null;
	}



}

