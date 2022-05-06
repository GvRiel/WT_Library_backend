package nl.workingtalentapp.library.persistance;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.workingtalentapp.library.domein.UserBeta;

public interface UserBetaRepo extends JpaRepository<UserBeta, Long>{

	Optional<UserBeta> findUserById(Long id);
	

}
