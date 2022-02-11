package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface UserService {
	
	public User addUser(User register) throws AlreadyExistsException;
	public String updateUser(Long id, User register) throws IdNotFoundException;
	public User getUserById(Long id) throws IdNotFoundException;
	public User[] getAllUsers() throws javax.naming.InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException;
	public Optional<List<User>> getAllUserDetails() ;
	public String deleteUserById(Long id) throws IdNotFoundException;
}
