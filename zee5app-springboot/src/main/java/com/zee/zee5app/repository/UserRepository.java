package com.zee.zee5app.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, String> {

	//custom jpa method // we will not write any def and only just declaration
//	Boolean existsByEmail(String email);
//	Boolean existsByContactNumber(BigDecimal contactNumber);
	//checking both condition using AND
	// this can also be done for other conditions like OR
	Boolean existsByEmailAndContactNumber(String email,BigInteger contactNumber);
	
}
