package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;

public interface UserService {
	
	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Register getUserById(String id);
	public Register[] getAllUsers();
	public String deleteUserById(String id);
}
