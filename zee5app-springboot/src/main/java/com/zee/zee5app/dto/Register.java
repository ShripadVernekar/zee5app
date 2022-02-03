package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
// ORM mapping purpose
@Entity // entity class is used for ORM
//customize table name
@Table(name = "register")
public class Register implements Comparable<Register> {

	@Id
	@Column(name = "regId") // here camel case is converted to snake case(i.e reg_id)
	private String id;

	@Size(max = 50)
	@NotBlank
	private String firstName;

	@Size(max = 50)
	@NotBlank
	private String lastName;

	@Size(max = 50)
	@Email
	private String email;

	@Size(max = 100)
	@NotBlank
	private String password;

	@NotNull
	private BigDecimal contactNumber;

//	private members accessed only inside class

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub

		// return this.id.compareTo(o.getId()); // ascending order

		return o.id.compareTo(this.getId()); // descending order
	}

	@ManyToMany
	// 3rd table
	// registered user(regid) and role(roleid)					//this is primary key of first table
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "regId"), 
	inverseJoinColumns = @JoinColumn(name = "roleId"))
									// above one is primary key of another table
	private Set<Role> roles = new HashSet<>();

	
	@OneToOne(mappedBy = "register")
	private subscription Subscription;
	
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
