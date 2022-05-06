package nl.workingtalentapp.library.persistance;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.workingtalentapp.library.domein.User;

@Component
public interface UserRepository extends JpaRepository<User, Long>{
	  void deleteUserById(Long id);

	    Optional<User> findUserById(Long id);	
}
