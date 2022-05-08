package nl.workingtalentapp.library.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.User;
import nl.workingtalentapp.library.persistance.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/user")
public class UserEndpoint {
	
	 private final UserService userService;
	 public UserEndpoint(UserService UserService) {
	        this.userService = UserService;
	    }
	
	
	@GetMapping("/all/dummy")
	public Iterable<User> ListUsersDummy(){
		return this.userService.findStaticUsers();
	}
	
	@GetMapping("/all")
	public Iterable<User> ListUsers(){
		return this.userService.findAllUsers();
	}
	
	@GetMapping("/find/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username){
		User user = this.userService.findByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
		//return userService.findAll();
	}
	
	@GetMapping("/find/{user_id}/")
	public ResponseEntity<User> getUserById(@PathVariable("user_id") int user_id){
	User user = this.userService.findById(user_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
	}


	//DELETE 
//	@DeleteMapping("/delete/{user_id}")
//	public ResponseEntity<Void> deleteUser(
//			 @PathVariable int user_id){
//		
//		//User user = userService.deleteById(id);
//		userService.deleteById(user_id);
//		
//		return ResponseEntity.noContent().build();
//		//return ResponseEntity.notFound().build();
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> UpdateUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	//Edit/Update a User
	//PUT /u
	  @PutMapping("/update")
	    public ResponseEntity<User> updateBoek(@RequestBody User user) {
	        User updateUser = userService.updateUser(user);
	        return new ResponseEntity<>(updateUser, HttpStatus.OK);
	  }
	        
	@PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
}
