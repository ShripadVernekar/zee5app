package com.learning.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })

public class Register {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int regId;

	@Size(max = 50)
	@NotBlank
	private String name;

	@Size(max = 50)
	@Email
	private String email;

	@Size(max = 100)
	@NotBlank
	private String password;

	@Size(max = 100)
	@NotBlank
	private String address;

	public Register(String name, String email, String password, String address) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "regId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Login login;


}