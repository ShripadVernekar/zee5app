package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "regId")
	private User register;
	
}
