package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.UserService;

@RestController
//REST API: RESPONSE wherever we have to share the response that method  must be marked with @ResponseBody

//1000emethods ---> @Responsebody ---> 1000times so they introduced @RestController
@RequestMapping("/users")
public class SubscriptionController {

	// adding user info into the table
	// info will be shared by the client in terms of JSON object
	// do we need to read that json Object? ===> yes 15 // where is this json object
	// is available in request? => requestbody
	// do we need to read that requestbody content ? yes

	// do we need to transform json object to Java object?yes ==> @RequestBody
	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException {

		Register result;

		result = userService.addUser(register);
		System.out.println(result);
		return ResponseEntity.status(201).body(result);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException{
		Register register = userService.getUserById(id);
		return ResponseEntity.ok(register);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {
		Optional<List<Register>> optional = userService.getAllUserDetails();
		
		if(optional.isEmpty()) {
			Map<String, String> hashMap = new HashMap<>();
			hashMap.put("message", "No record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok(optional.get());
	}
	
}
