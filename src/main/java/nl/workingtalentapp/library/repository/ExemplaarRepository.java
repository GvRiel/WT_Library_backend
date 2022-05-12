package nl.workingtalentapp.library.repository;
import nl.workingtalentapp.library.domein.Exemplaar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExemplaarRepository  extends CrudRepository<Exemplaar, Long> {
	
	void deleteExemplaarById(Long id);
	
}
