package com.zee.zee5app.repoistory;

import java.util.Optional;

import com.zee.zee5app.dto.Register;

public interface UserRepoistory {

	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id);
	public Register[] getAllUsers();
	public String deleteUserById(String id);
	
}
