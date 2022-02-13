package com.zee.zee5app.dto;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonIgnore;

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
//@AllArgsConstructor
// ORM mapping purpose
@Entity // entity class is used for ORM
//customize table name
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
											@UniqueConstraint(columnNames = "email") })

public class User implements Comparable<User> {

	@Id
	@Column(name = "regId") // here camel case is converted to snake case(i.e reg_id)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(max = 50)
	@NotBlank
	private String firstName;

	@Size(max = 50)
	@NotBlank
	private String lastName;

	@Size(max = 50)
	@NotBlank
	private String username;

	@Size(max = 50)
	@Email
	private String email;

	@Size(max = 100)
	@NotBlank
	private String password;

	private BigInteger contactNumber;

	 public User(String username, String email, String password, String firstName, String lastName) {
		    this.username = username;
		    this.email = email;
		    this.password = password;
		    this.firstName = firstName;
		    this.lastName = lastName;
	}
	
	
//	private members accessed only inside class

	@Override
	public int compareTo(User o) {

		// return this.id.compareTo(o.getId()); // ascending order

		return o.id.compareTo(this.getId()); // descending order
	}

	@ManyToMany(fetch = FetchType.LAZY)
//	@JsonIgnore  //this annotation avoids recursion
	// 3rd table
	// registered user(regid) and role(roleid) //this is primary key of first table
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "regId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	// above one is primary key of another table
	private Set<Role> roles = new HashSet<>();
	
/*
//	@JsonIgnore
	@OneToOne(mappedBy = "register")
	private Subscription Subscription;
*/
//	@JsonIgnore
//	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Login login;

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
