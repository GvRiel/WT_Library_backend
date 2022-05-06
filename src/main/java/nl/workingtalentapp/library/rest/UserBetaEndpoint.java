package nl.workingtalentapp.library.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.UserBeta;
import nl.workingtalentapp.library.persistance.UserBetaService;

@RestController
@RequestMapping("/user")
public class UserBetaEndpoint {
	private UserBetaService us;
	
	public UserBetaEndpoint(UserBetaService us) {
		this.us = us;
	}
	
	@GetMapping("/userlist")
	public ResponseEntity<List<UserBeta>> getUsers(){
		List<UserBeta> users = us.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<UserBeta> getUserById(@PathVariable("id") Long id){
		UserBeta user = us.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<UserBeta> AddUser(@RequestBody UserBeta user){
		UserBeta newuser = us.addUser(user);
		return new ResponseEntity<>(newuser, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserBeta> UpdateUser(@RequestBody UserBeta user){
		UserBeta updateuser = us.updateUser(user);
		return new ResponseEntity<>(updateuser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> UpdateUser(@PathVariable("id") Long id){
		us.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
