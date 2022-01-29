package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repoistory.UserRepoistory;
import com.zee.zee5app.repoistory.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserService service;
	
	private UserServiceImpl() throws IOException{
		
	}
	
	public static UserService getInstance() throws IOException {
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
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepoistory.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException, javax.naming.InvalidNameException, InvalidEmailException {
		// TODO Auto-generated method stub
		return userRepoistory.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() throws javax.naming.InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return userRepoistory.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		return userRepoistory.deleteUserById(id);
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws javax.naming.InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return userRepoistory.getAllUserDetails();
	}

}
