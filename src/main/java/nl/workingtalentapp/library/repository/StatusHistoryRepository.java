package nl.workingtalentapp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import nl.workingtalentapp.library.domein.StatusHistory;

import java.util.List;
import java.util.Optional;

@Component
public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long>{
	StatusHistory findStatusHistoryById(Long id);
	
	List<StatusHistory> findStatusHistoryByUserId(Long user_id);

}
