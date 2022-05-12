package nl.workingtalentapp.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.workingtalentapp.library.domein.UserHistory;

@Component
public interface UserHistoryRepository extends CrudRepository<UserHistory, Long> {

}