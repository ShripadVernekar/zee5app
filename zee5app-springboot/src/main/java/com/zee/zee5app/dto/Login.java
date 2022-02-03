package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // entity class is used for ORM
@Table(name = "login")
public class Login {
	
	@Id
	@Column(name = "userName")
	private String userName;
	
	@Size(max = 100)
	@NotBlank
	private String password;
	
	@NotBlank
	private String regId;
	
}
