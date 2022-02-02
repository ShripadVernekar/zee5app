package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepoistory;

	@Override
	public String addUser(Register register) {
		Register register2 = userRepoistory.save(register);
		if (register2 != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException,
			InvalidNameException, InvalidPasswordException, javax.naming.InvalidNameException, InvalidEmailException {
		return userRepoistory.findById(id);
	}

	@Override
	public Register[] getAllUsers() throws javax.naming.InvalidNameException, InvalidIdLengthException,
			InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		List<Register> list = userRepoistory.findAll();
		Register[] arr = new Register[list.size()];
		return list.toArray(arr);
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws javax.naming.InvalidNameException,
			InvalidIdLengthException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepoistory.findAll());
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {

		try {
			Optional<Register> optional = this.getUserById(id);
			if (optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			} else {
				userRepoistory.deleteById(id);
				return "success";
			}
		} catch (javax.naming.InvalidNameException | IdNotFoundException | InvalidIdLengthException
				| InvalidNameException | InvalidPasswordException | InvalidEmailException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
