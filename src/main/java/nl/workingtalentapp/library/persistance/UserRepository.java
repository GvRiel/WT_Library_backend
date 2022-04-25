package nl.workingtalentapp.library.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.workingtalentapp.library.domein.User;

@Component
public interface UserRepository extends CrudRepository<User, Long>{

}
