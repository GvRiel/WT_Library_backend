package nl.workingtalentapp.library.repository;

import nl.workingtalentapp.library.domein.StatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long>{
	StatusHistory findStatusHistoryById(Long id);
	
	List<StatusHistory> findStatusHistoryByUserId(Long user_id);



}