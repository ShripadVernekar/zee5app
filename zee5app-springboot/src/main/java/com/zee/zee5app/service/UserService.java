package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface UserService {
	
	public String addUser(Register register);
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException, javax.naming.InvalidNameException, InvalidEmailException;
	public Register[] getAllUsers() throws javax.naming.InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException;
	public Optional<List<Register>> getAllUserDetails() throws javax.naming.InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException;
	public String deleteUserById(String id) throws IdNotFoundException;
}
