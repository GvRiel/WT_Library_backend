package nl.workingtalentapp.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import nl.workingtalentapp.library.domein.*;

@Component
public interface StatusHistoryRepository extends CrudRepository<StatusHistory, Long>{

}
