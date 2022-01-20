package com.zee.zee5app.service.impl;

import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repoistory.UserRepoistory;
import com.zee.zee5app.repoistory.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserService service;
	
	public static UserService getInstance() {
		if (service == null) {
			service = new UserServiceImpl();
		}
		return service;
	}
	
	UserRepoistory userRepoistory = UserRepositoryImpl.getInstance();
	
	@Override
	public String addUser(Register register) {
		return userRepoistory.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return userRepoistory.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepoistory.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return userRepoistory.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return userRepoistory.deleteUserById(id);
	}

}
