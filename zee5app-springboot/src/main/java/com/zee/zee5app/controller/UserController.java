package com.zee.zee5app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.payload.request.SignupRequest;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.service.UserService;

@RestController
//REST API: RESPONSE wherever we have to share the response that method  must be marked with @ResponseBody

//1000emethods ---> @Responsebody ---> 1000times so they introduced @RestController
@RequestMapping("/api/auth")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		
		if(userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity.badRequest()
								 .body(new MessageResponse("Error: Username already taken!"));
		}
		
		if(userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest()
								 .body(new MessageResponse("Error: Email is already in use!"));
		}
		
		//user's account	
		User user = new User(signupRequest.getUsername(), 
							 signupRequest.getFirstName(), 
							 signupRequest.getLastName(), 
							 signupRequest.getEmail(), 
							 signupRequest.getPassword());
		
		//retreiving role details	
		Set<String> strRoles = signupRequest.getRole();
		System.out.println(strRoles);
		Set<Role> roles =  new HashSet<>();
		
		if(strRoles == null) {
			Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
					.orElseThrow(
							 () -> new RuntimeException("Error: role not found")
							);
			
		} else {
			strRoles.forEach(e -> {
				switch (e) {
				case "admin":
					Role roleAdmin = roleRepository.findByRoleName(EROLE.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: role not found"));
					roles.add(roleAdmin);
					break;

				case "moderator":
					Role roleMod = roleRepository.findByRoleName(EROLE.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: role not found"));
					roles.add(roleMod);
					break;

				default:
					break;
				}
			});
		}
		
		user.setRoles(roles);
		userRepository.save(user);		
		return ResponseEntity.status(201).body(new MessageResponse("User created successfully"));
	}
	

/*
	// adding user info into the table
	// info will be shared by the client in terms of JSON object
	// do we need to read that json Object? ===> yes 15 // where is this json object
	// is available in request? => requestbody
	// do we need to read that requestbody content ? yes
	// do we need to transform json object to Java object?yes ==> @RequestBody
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User register) throws AlreadyExistsException {

		User result;

		result = userService.addUser(register);
		System.out.println(result);
		return ResponseEntity.status(201).body(result);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) throws IdNotFoundException{
		User register = userService.getUserById(id);
		return ResponseEntity.ok(register);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {
		Optional<List<User>> optional = userService.getAllUserDetails();
		
		if(optional.isEmpty()) {
//			Map<String, String> hashMap = new HashMap<>();
//			hashMap.put("message", "No record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No record found"));
		}
		return ResponseEntity.ok(optional.get());
	}
*/
	
}
