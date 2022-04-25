package nl.workingtalentapp.library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.User;
import nl.workingtalentapp.library.persistance.UserService;

@RestController
@CrossOrigin
public class UserEndpoint {

	@Autowired
	UserService shs;
	
	@GetMapping(value = "/newUser")
	public String eersteUser() {
		shs.proberen();
		return "doet het";
	}
	
	@GetMapping(value = "/users")
	public Iterable<User> ListUsers(){
		return shs.findAllUsers();
}
}
