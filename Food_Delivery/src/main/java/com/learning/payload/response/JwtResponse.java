package com.learning.payload.response;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {
// class to get and set the jwt response
	private String token;  
	private String type = "Bearer";
	private int id;
	private String email;
	private List<String> roles;
	
	public JwtResponse(String token, int id, String email,List<String> roles) {
		this.token = token;
		this.id = id;
		this.email = email;	
		this.roles = roles;
	}
	
	
}
