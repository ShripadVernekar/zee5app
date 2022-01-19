package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repoistory.UserRepository;

public class UserService {
	private UserRepository repository = UserRepository.getInstance();
	// service consuming repository
	
	private UserService() {
		// TODO Auto-generated constructor stub
	}
	
	//if we want to create single obj than we have to create it inside the same class
	//and we have to share the ref with others and 
	// to do this we have to declare a method
	
	private static UserService service = null;
	//this would be static
	//only one copy
	
	//to make object independent we added static keyword for execution
	public static UserService getInstance() {
		
		//static method will only access static ref
		if(service == null)
			service = new UserService();
		return service;
	}
	
	public String addUser(Register register) {
		return this.repository.addUser(register);
	}
	
	public Register getUserById(String id) {
		return this.repository.getUserById(id);
	}
	
	public Register[] getUsers() {
		return this.repository.getUsers();
	}
	
	public String updateUser(String id, Register register) {
		return this.repository.updateUser(id, register);
	}
	
	public String deleteUser(String id) {
		return this.repository.deleteUser(id);
	}
}//end of class
