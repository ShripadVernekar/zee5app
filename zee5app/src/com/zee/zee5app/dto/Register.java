package com.zee.zee5app.dto;

//import java.util.Objects;

import javax.naming.InvalidNameException;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Register {
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	private String email;
	private String password;
//	private members accessed only inside class
	
	public Register(String id, String firstName, String lastName, String email, String password) 
			throws InvalidNameException, InvalidIdLengthException {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.email = email;
		this.password = password;
	}
	
	
	public void setId(String id) throws InvalidIdLengthException {
	// throws: it will provide the list of exceptions maybe raised
	// it will hold list of checked exceptions
		if(id.length() < 6) {
			//raise invalidId exception
			//exception obj is created by jvm but here we have to create & raise user defined exception obj
			throw new InvalidIdLengthException("id length is less than or equal to 6"); //throws exception
		}
		this.id = id;
	}
	
	public void setFirstName(String firstName) throws InvalidNameException {
		if (firstName == null || firstName == "" || firstName.length() <2) {
			throw new InvalidNameException("first name not valid");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) throws InvalidNameException {
		if (lastName == null || lastName == "" || lastName.length() <2) {
			throw new InvalidNameException("last name not valid");
		}
		this.lastName = lastName;
	}


//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, id, lastName, password);
//	}
//

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Register other = (Register) obj;
//		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
//				&& Objects.equals(password, other.password);
//	}
//
//	
	
}
