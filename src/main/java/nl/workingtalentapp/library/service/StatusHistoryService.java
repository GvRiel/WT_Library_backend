package nl.workingtalentapp.library.service;

import nl.workingtalentapp.library.domein.Exemplaar;
import nl.workingtalentapp.library.domein.StatusHistory;
import nl.workingtalentapp.library.domein.User;
import nl.workingtalentapp.library.domein.Boek;
import nl.workingtalentapp.library.repository.StatusHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatusHistoryService {
    public final StatusHistoryRepository shRepo;


    @Autowired
    public StatusHistoryService(StatusHistoryRepository shRepo) {
        this.shRepo = shRepo;
    }

    public List<StatusHistory> findAllStatusHistory() {
        return shRepo.findAll();
    }

    public StatusHistory findStatusHistoryId(Long id) {
        Optional<StatusHistory> optionalStatusHistory = shRepo.findById(id);
        if (optionalStatusHistory.isPresent()) {
            StatusHistory statushistory = optionalStatusHistory.get();
            return statushistory;
        } else {
            return null;
        }
//        return shRepo.findStatusHistoryById(id);
    }


    public List<StatusHistory> findStatusHistoryUser(Long user_id) {
		List<StatusHistory> StatusHistories = shRepo.findAll();
        List<StatusHistory> returnStatusHistories = new ArrayList<>();
		for(StatusHistory sh:StatusHistories) {
			if(sh.getUser().getId().equals(user_id)) {
				returnStatusHistories.add(sh);
			}
		}
        return returnStatusHistories;
    }

    public List<StatusHistory> findStatusHistoryCopy(Long copy_id) {
		List<StatusHistory> StatusHistories = shRepo.findAll();
        List<StatusHistory> returnStatusHistories = new ArrayList<>();
		for(StatusHistory sh:StatusHistories) {
			if(sh.getExemplaar().getId().equals(copy_id)) {
				returnStatusHistories.add(sh);
			}
		}
        return returnStatusHistories;
    }

    public List<StatusHistory> findStatusHistoryBook(Long book_id) {
		List<StatusHistory> StatusHistories = shRepo.findAll();
        List<StatusHistory> returnStatusHistories = new ArrayList<>();
		for(StatusHistory sh:StatusHistories) {
			if(sh.getExemplaar().getBoek().getId().equals(book_id)) {
				returnStatusHistories.add(sh);
			}
		}
        return returnStatusHistories;
    }

    public StatusHistory addStatusHistory(StatusHistory newStatusHistory, User user, Exemplaar exemplaar) {
        newStatusHistory.assignUser(user);
        newStatusHistory.assignExemplaar(exemplaar);
        newStatusHistory.setShCode(UUID.randomUUID().toString());
        return shRepo.save(newStatusHistory);
    }

    public List<StatusHistory> findStatusHistoryStatus(String status, Boolean active) {
        List<StatusHistory> StatusHistories = shRepo.findAll();
        List<StatusHistory> returnStatusHistories = new ArrayList<>();
        for (StatusHistory sh : StatusHistories) {
            if (sh.getStatus().equals(status) && sh.isActive() == active) {
                returnStatusHistories.add(sh);
            }
        }
        return returnStatusHistories;
    }

    public StatusHistory updateStatusHistory(StatusHistory statusHistory) {
        return shRepo.save(statusHistory);
    }

    public void setInactive(Long exemplaar_id) {
        List<StatusHistory> StatusHistories = shRepo.findAll();
        for (StatusHistory sh : StatusHistories) {
            if (sh.getExemplaar().getId() == exemplaar_id && sh.isActive()) {
                sh.setActive(false);
            }
        }
    }
}