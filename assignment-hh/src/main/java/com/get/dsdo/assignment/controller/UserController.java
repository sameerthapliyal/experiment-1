package com.get.dsdo.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.get.dsdo.assignment.util.JSONFormatValidator;

@RestController    
@RequestMapping(path="/dsdo") 
public class UserController {
	
	@Autowired 
	private UserRepository userRepository;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user) {
		
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getUser_info());
		
		JSONFormatValidator jsonFormatValidator = new JSONFormatValidator();

		try {
			jsonFormatValidator.ProcessUserInfoJSON(user.getUser_info());
			
			userRepository.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//shoud have better exception handling here
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns all users in the database
		return userRepository.findAll();
	}
	

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
		User user = userRepository.findOne(userId);
	    
	    if(user == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    return ResponseEntity.ok().body(user);
	}
	 
}
