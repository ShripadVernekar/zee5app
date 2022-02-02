package com.zee.zee5app.repoistory;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface UserRepoistory {

	public String addUser(Register register);
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException, InvalidEmailException, javax.naming.InvalidNameException;
	public Register[] getAllUsers() throws javax.naming.InvalidNameException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException;
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, javax.naming.InvalidNameException, InvalidEmailException, InvalidPasswordException;
	public String deleteUserById(String id) throws IdNotFoundException;
	
}
