package com.zee.zee5app.payload.request;

import java.util.Set;
import javax.validation.constraints.*;
import lombok.Data;

@Data

public class SignupRequest {

	@NotBlank
	@Size(min = 3, max = 20)
	private String username;

	@NotBlank
	@Size(min = 3, max = 50)
	private String firstName;

	@NotBlank
	@Size(min = 3, max = 50)
	private String lastName;

	@NotBlank
	@Size(max = 60)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	private Set<String> role;

}