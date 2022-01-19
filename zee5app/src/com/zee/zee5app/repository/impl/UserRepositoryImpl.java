package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repoistory.UserRepoistory;

public class UserRepositoryImpl implements UserRepoistory {
	
	private Register[] registers = new Register[10];
	private static int count = -1;

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
		if(count == registers.length-1) {
			Register temp[] = new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers = temp;
			registers[++count] = register;
			return "success";
		}
		
		registers[++count] = register;
		return "success";
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0; i< registers.length; i++) {
			if(registers[i] != null && registers[i].getId().equals(id)) {
				registers[i] = register;
				return "done";
			}
		}
		return "not found";
	}

	@Override
	public Register getUserById(String id) {
		// TODO Auto-generated method stub
		 for (Register register : registers) {
			 if (register !=null && register.getId().equals(id))
				 return register;
		 }
		 return null;
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return registers;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0; i< registers.length; i++) {
			if(registers[i] != null && registers[i].getId().equals(id)) {
				registers[i] = registers[i+1];
			}
		}
		return "done";
	}

}
