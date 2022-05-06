package nl.workingtalentapp.library.persistance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.UserBeta;
import nl.workingtalentapp.library.exception.UserNotFoundException;

@Service
public class UserBetaService {
	private UserBetaRepo ur;
	
	@Autowired
	public UserBetaService(UserBetaRepo ur) {
		this.ur = ur;
	}
	
	public UserBeta addUser (UserBeta user) {
		user.setUserID(UUID.randomUUID().toString());
		return ur.save(user);
	}
	
	public List<UserBeta> findAllUsers(){
		return ur.findAll();
	}
	
	public UserBeta updateUser(UserBeta user) {
		return ur.save(user);
	}
	
	public UserBeta findUserById(Long id) {
		return ur.findUserById(id).
				orElseThrow(() -> new UserNotFoundException("User not found"));
	}
	
	public void deleteUser(Long id) {
		ur.deleteById(id);
	}


}
