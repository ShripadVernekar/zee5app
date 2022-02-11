package com.zee.zee5app.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//custom jpa method // we will not write any def and only just declaration
//	Boolean existsByEmail(String email);
//	Boolean existsByContactNumber(BigDecimal contactNumber);
	//checking both condition using AND
	// this can also be done for other conditions like OR
	Boolean existsByEmailAndContactNumber(String email,BigInteger contactNumber);
	Optional<User> findByUsername(String username);
	
}
