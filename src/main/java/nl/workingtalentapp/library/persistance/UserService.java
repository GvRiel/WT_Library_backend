package nl.workingtalentapp.library.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository shr;
	
	public void proberen() {
		User sh = new User();
		sh.setName("ezra");
		shr.save(sh);
	}
	
	public Iterable<User> findAllUsers() {
		return shr.findAll();
	}
}
