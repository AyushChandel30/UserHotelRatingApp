package yahu.in.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yahu.in.entity.User;
import yahu.in.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	private UserService us;
	
	public UserRestController(UserService us) {
		this.us=us;
	}
	
	@PostMapping
	public ResponseEntity<User> saveOne (@RequestBody User u) {
		User saveUser = us.saveUser(u);
		//return new ResponseEntity<User> (saveUser, HttpStatus.CREATED);
		//or
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	@GetMapping ("/{userId}")
	public ResponseEntity<User> getOneUser (@PathVariable ("userId") String userId){
		User oneUser = us.getOneUser(userId);
		//return ResponseEntity.status(HttpStatus.OK).body(oneUser);
		//or
		return ResponseEntity.ok(oneUser);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers (){
		List<User> allUser = us.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(allUser);
	}
	
	@DeleteMapping ("/{userId}")
	public ResponseEntity<String> deleteOne (@PathVariable("userId") String userId){
		String msg = us.deleteOne(userId);
		return ResponseEntity.ok(msg);
	}
	
	
	

}
