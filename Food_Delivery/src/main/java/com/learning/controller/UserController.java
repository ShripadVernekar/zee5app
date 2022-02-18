package com.learning.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.EROLE;
import com.learning.dto.Register;
import com.learning.dto.Role;
import com.learning.exception.IdNotFoundException;
import com.learning.payload.request.LoginRequest;
import com.learning.payload.request.SignupRequest;
import com.learning.payload.response.JwtResponse;
import com.learning.payload.response.MessageResponse;
import com.learning.repo.LoginRepository;
import com.learning.repo.RoleRepository;
import com.learning.repo.UserRepository;
import com.learning.security.jwt.JwtUtils;
import com.learning.security.services.UserDetailsImpl;
import com.learning.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	AuthenticationManager authenticationManager;
	

	@PostMapping("/register")
	public ResponseEntity<?> addUser(@Valid @RequestBody SignupRequest signupRequest) {

		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		Register user = new Register(signupRequest.getName(), signupRequest.getEmail(),
				passwordEncoder.encode(signupRequest.getPassword()), signupRequest.getAddress());

		Set<String> strRoles = signupRequest.getRole();
System.out.println(signupRequest);
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: role not found"));
			roles.add(userRole);

		} else {
			strRoles.forEach(e -> {
				switch (e) {
				case "admin":
					Role roleAdmin = roleRepository.findByRoleName(EROLE.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: role not found"));
					roles.add(roleAdmin);
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

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername()
						, loginRequest.getPassword()));
		System.out.println(loginRequest);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> roles = userDetailsImpl.getAuthorities()
				.stream()
				.map(i->i.getAuthority())
				.collect(Collectors.toList());

	
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetailsImpl.getId(),
				userDetailsImpl.getEmail(),
				roles));
	}

	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		Optional<List<Register>> optional = userService.getAllUserDetails();

		if (optional.isEmpty()) {
//			return ResponseEntity.ok().body("[]");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok(optional.get());
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws IdNotFoundException {

		Register register = userService.getUserById(id);
		return ResponseEntity.ok(register);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Register register)
			throws IdNotFoundException {
		String result = userService.updateUser(id, register);
		if (result.equals("success")) {
			return ResponseEntity.status(201).body(result);
		} else {
			Map<String, String> hashMap = new HashMap<>();
			hashMap.put("message", "Sorry user With " + id + " not found");
			return ResponseEntity.badRequest().body(hashMap);
		}
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) throws IdNotFoundException {

		String result = userService.deleteUserById(id);
		if (result.equals("success")) {
			return ResponseEntity.ok("User Deleted Successfully");
		} else {
			Map<String, String> hashMap = new HashMap<>();
			hashMap.put("message", "Sorry user With " + id + " not found");
			return ResponseEntity.badRequest().body(hashMap);
		}
	}

}
