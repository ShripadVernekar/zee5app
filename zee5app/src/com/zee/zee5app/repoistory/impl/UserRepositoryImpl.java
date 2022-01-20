package com.zee.zee5app.repoistory.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repoistory.UserRepoistory;


public class UserRepositoryImpl implements UserRepoistory {
	
	private ArrayList<Register> arrayList = new ArrayList<Register>();
//	private static int count = -1;

	private UserRepositoryImpl() {
		
	}
	
	private static UserRepoistory repository;
	
	public static UserRepoistory getInstance() {
		if (repository == null)
			repository = new UserRepositoryImpl();
		return repository;
	}

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean res = this.arrayList.add(register);
		if (res)
			return "success";
		return "failed";
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		Register reg = null;
		for(Register register : arrayList) {
			if(register.getId().equals(id)) {
				reg = register;
			}
		}
		return Optional.ofNullable(reg);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
