package nl.workingtalentapp.library.persistance;
import nl.workingtalentapp.library.domein.Exemplaar;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExemplaarRepository  extends CrudRepository<Exemplaar, Long> {
	Optional<Exemplaar> vindExemplaar(Long id);
}
