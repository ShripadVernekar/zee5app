package com.learning.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.Login;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.service.LoginService;

@Service

public class LoginServiceImpl implements LoginService {

	@Autowired
	private  LoginRepository LoginRepository;
//
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = LoginRepository.save(login);
		if(login2 != null) {
			return "success";
		}else {
			return "fail";
		}
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		try {
			Optional<Login> optional = LoginRepository.findById(userName);
			if (optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			} else {
				LoginRepository.deleteById(userName);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new IdNotFoundException(e.getMessage());
			return "fail";
		}
	}


}
