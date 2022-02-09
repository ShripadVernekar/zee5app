package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.learning.dto.Login;
import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.service.UserService;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.repo.UserRepository;

@RestController
@RequestMapping()
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	LoginRepository loginRepository;
	
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException {

		Register result;
		result = userService.addUser(register);
		
		return ResponseEntity.status(201).body(result);
	}
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@Valid @RequestBody Login login) throws IdNotFoundException, AlreadyExistsException{
		
		Map<String, String> hashMap = new HashMap<>();
		if(loginRepository.existsByuserNameAndPassword(login.getUserName(), login.getPassword()) == true) {
			hashMap.put("message", "Success!!");
			return ResponseEntity.status(200).body(hashMap);
		}else {
			hashMap.put("message", "Fail!!");
			return ResponseEntity.status(403).body(hashMap);
		}
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		Optional<List<Register>> optional = userService.getAllUserDetails();
		
		if(optional.isEmpty()) {
//			return ResponseEntity.ok().body("[]");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok(optional.get());
	}

	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws IdNotFoundException{
		
		Register register = userService.getUserById(id);
		return ResponseEntity.ok(register);
	}
	
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Register register) throws IdNotFoundException {
		String result = userService.updateUser(id,register);
		if(result.equals("success")) {
			return ResponseEntity.status(201).body(result);
		}else {
			Map<String, String> hashMap = new HashMap<>();
			hashMap.put("message", "Sorry user With " + id +" not found");
			return ResponseEntity.badRequest().body(hashMap);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) throws IdNotFoundException {
	
		String result = userService.deleteUserById(id);
		if(result.equals("success")) {
			return ResponseEntity.ok("User Deleted Successfully");
		}else {
			Map<String, String> hashMap = new HashMap<>();
			hashMap.put("message", "Sorry user With " + id +" not found");
			return ResponseEntity.badRequest().body(hashMap);
		}
	}

}
