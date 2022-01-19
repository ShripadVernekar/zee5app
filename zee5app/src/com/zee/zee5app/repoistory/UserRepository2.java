package com.zee.zee5app.repoistory;

//import java.util.Iterator;

import com.zee.zee5app.dto.Register;

// repo. objects are used to call only repo methods 
// can we do this using 1 object?
public class UserRepository2 {
	
	private Register[] registers = new Register[10];
	private static int count = -1;
	private UserRepository2() {
		// TODO Auto-generated constructor stub
	}
	
	// to return all user details
	public Register[] getUsers() {
		return registers;
	}
	
	//update user info
	public String updateUser(String id, Register register) {
		int i = 0;
		for(i=0; i< registers.length; i++) {
			if(registers[i] != null && registers[i].getId().equals(id)) {
				registers[i] = register;
				return "done";
			}
		}
		return "not found";
	}
	
	//delete user
	public String deleteUser(String id) {
		int i = 0;
		for(i=0; i< registers.length; i++) {
			if(registers[i] != null && registers[i].getId().equals(id)) {
				registers[i] = registers[i+1];
			}
		}
		return "done";
	}
	
	//get user details based on id's
	public Register getUserById(String id) {
		 for (Register register : registers) {
			 if (register !=null && register.getId().equals(id))
				 return register;
		 }
		 return null;
	}
	
	// add a new user
	public String addUser(Register reg) {
		if(count == registers.length-1) {
			Register temp[] = new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers = temp;
			registers[++count] = reg;
			return "success";
		}
		
		registers[++count] = reg;
		return "success";
	}
		
	private static UserRepository2 userRepository;
	
	public static UserRepository2 getInstance() {
		if(userRepository==null)
			userRepository = new UserRepository2();
		return userRepository;
	}

}//end of class