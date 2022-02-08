package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.dto.Login;
import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;


public interface UserService {
	public Register addUser(Register register) throws AlreadyExistsException;
	public String authenticate(Login login) throws AlreadyExistsException, IdNotFoundException;
	public String updateUser(Integer id, Register register) throws IdNotFoundException;
	public Register getUserById(Integer id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUserDetails() ;
	public String deleteUserById(Integer id) throws IdNotFoundException;
}
