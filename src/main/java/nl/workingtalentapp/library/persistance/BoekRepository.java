package nl.workingtalentapp.library.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.workingtalentapp.library.domein.Boek;

@Component
public interface BoekRepository extends CrudRepository<Boek, Long> {

	
}
