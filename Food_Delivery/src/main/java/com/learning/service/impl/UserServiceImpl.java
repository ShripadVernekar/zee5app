package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.dto.Login;
import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.repo.UserRepository;
import com.learning.service.LoginService;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepoistory;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	LoginService loginService;
	

	@Override
	@Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if (userRepoistory.existsByEmail(register.getEmail()) == true) {
			throw new AlreadyExistsException("This email already exists in DB");
		}
		
		Register register2 = userRepoistory.save(register);
		if (register2 != null) {

			if (loginRepository.existsByuserName(register.getEmail()))
				throw new AlreadyExistsException("this record exists in DB");
			String res = loginService.addCredentials(new Login(register.getEmail(), register.getPassword(),register2));

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
	public String updateUser(Integer id, Register register) throws IdNotFoundException {
		if(userRepoistory.existsById(id) == false) {
			throw new IdNotFoundException("Invalid Id");
		}
		register.setRegId(id);
		if (userRepoistory.save(register)!=null) {
			return "success" ;
		}else {
			return "failure";
		}
	}

	@Override
	public Register getUserById(Integer id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = userRepoistory.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Sorry user With " + id +" not found");
		} else {
			return optional.get();
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepoistory.findAll());
	}

	@Override
	public String deleteUserById(Integer id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register optional;
		try {
			optional = this.getUserById(id);
			if (optional == null) {
				throw new IdNotFoundException("Sorry user With " + id +" not found");
			} else {
				userRepoistory.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}


}
