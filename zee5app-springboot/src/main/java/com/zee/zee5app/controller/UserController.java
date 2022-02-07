package com.zee.zee5app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;

@RestController
//REST API: RESPONSE wherever we have to share the response that method  must be marked with @ResponseBody

//1000emethods ---> @Responsebody ---> 1000times so they introduced @RestController
@RequestMapping("/api/users")
public class UserController {

	// adding user info into the table
	// info will be shared by the client in terms of JSON object
	// do we need to read that json Object? ===> yes 15 // where is this json object
	// is available in request? => requestbody
	// do we need to read that requestbody content ? yes

	// do we need to transform json object to Java object?yes ==> @RequestBody

	@PostMapping("/addUser")
	public String addUser(@RequestBody Register register) {
		return register.toString();
	}

}
