package com.zee.zee5app.payload.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MovieRequest {

	@NotBlank
	private String movieName;

	@Max(value = 70)
	private int ageLimit;

	@NotBlank
	private String genre;

	@NotBlank
	private String language;

	@NotBlank
	private String trailer;

	@NotBlank
	private String cast;

	@NotNull
	private int length;

	@NotBlank
	private String releaseDate;
}
