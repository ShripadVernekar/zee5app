package com.zee.zee5app.service.impl;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repoistory.LoginRepoistory;
import com.zee.zee5app.service.LoginService;

@Service

public class LoginServiceImpl implements LoginService {

	private static LoginRepoistory loginRepoistory = null;
//	private static LoginService loginService;

//	private LoginServiceImpl() throws IOException {
//		loginRepoistory = LoginRepositoryImpl.getInstance();
//	}
//
//	public static LoginService getInstance() throws IOException {
//		if (loginService == null) {
//			loginService = new LoginServiceImpl();
//		}
//		return loginService;
//	}

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		return loginRepoistory.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		return loginRepoistory.deleteCredentials(userName);
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return loginRepoistory.changePassword(userName, password);
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		return loginRepoistory.changeRole(userName, role);
	}

}
