package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepoistory;
	@Autowired
	private LoginService loginService;
	@Autowired
	private LoginRepository loginRepository;

	@Override
	@Transactional(rollbackFor = AlreadyExistsException.class)
	public User addUser(User register) throws AlreadyExistsException {

		if (userRepoistory.existsByEmailAndContactNumber(register.getEmail(), register.getContactNumber()) == true) {
			throw new AlreadyExistsException("this record exists in DB");
		}

		User register2 = userRepoistory.save(register);
		if (register2 != null) {

			if (loginRepository.existsByuserName(register.getEmail()))
				throw new AlreadyExistsException("this record exists in DB");
			String res = loginService.addCredentials(new Login(register.getEmail(), register.getPassword(), register2));

			if (res.equals("success")) {
				return register2;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public User getUserById(Long id) throws IdNotFoundException {
		Optional<User> optional = userRepoistory.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id does not exists!!");
		} else {
			return optional.get();
		}
	}

	@Override
	public User[] getAllUsers() throws javax.naming.InvalidNameException, InvalidIdLengthException,
			InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		List<User> list = userRepoistory.findAll();
		User[] arr = new User[list.size()];
		return list.toArray(arr);
	}

	@Override
	public Optional<List<User>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepoistory.findAll());
	}

	@Override
	public String deleteUserById(Long id) throws IdNotFoundException {

		User optional;
		try {
			optional = this.getUserById(id);
			if (optional == null) {
				throw new IdNotFoundException("id not found!");
			} else {
				userRepoistory.deleteById(id);
				return "Record deleted!";
			}
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String updateUser(Long id, User register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
