package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

	Boolean existsByuserName(String userName);
	Boolean existsByuserNameAndPassword(String userName,String passowrd);
	
}
