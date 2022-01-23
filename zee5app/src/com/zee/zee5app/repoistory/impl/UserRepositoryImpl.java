package com.zee.zee5app.repoistory.impl;

import java.util.ArrayList;
//import java.util.set;

import java.util.List;
import java.util.Optional;
//import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repoistory.UserRepoistory;


public class UserRepositoryImpl implements UserRepoistory {
/*
*	private List<Register> set = new set<Register>();
*	private List<Register> set = new LinkedList<>();
*	private Set<Register> set = new LinkedHashSet<>();
*/
	private TreeSet<Register> set = new TreeSet<>();
	
//	Default size of set is 16
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
		boolean res = this.set.add(register);
//		System.out.println(set);
		if (res)
			return "success";
		return "failed";
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		if (optional.isPresent()) {
			set.remove(optional.get());
			boolean res = set.add(register);
			if(res) {
				return "Done";
			}else {
				return "fail";
			}
		}
		return "fail";
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		Register reg = null;
		for(Register register : set) {
			if(register.getId().equals(id)) {
				reg = register;
				break;
			}
		}
		return Optional.of(Optional
				.ofNullable(reg)
				.orElseThrow(()-> new IdNotFoundException("Id not found!")));
	}
/*
*	@Override
*	public Register getUserById(String id) throws IdNotFoundException {
*		// TODO Auto-generated method stub
*		Register reg = null;
*		for(Register register : set) {
*			if(register.getId().equals(id)) {
*				reg = register;
*			}
*		}
*		if (reg == null) {
*			throw new IdNotFoundException("id not found");
*		}else {
*			return reg;
*		}
//		return Optional.of(Optional.ofNullable(reg).orElseThrow(()-> new IdNotFoundException("Id not found!")));
*	}
*/

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		Register register[] = new Register[set.size()];
		return set.toArray(register);
	}
	
	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
//		Collections.sort(set);
//		return set;
		
		// to get asc from desc
		//set.descendingSet();
		
		return new ArrayList<>(set.descendingSet());
	}
	
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		if (optional.isPresent()) {
			boolean res = set.remove(optional.get());
			if(res) {
				return "Done";
			}else {
				return "fail";
			}
		}
		return "fail";
	}

	
	
	
}
