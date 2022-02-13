package com.zee.zee5app.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EpisodeRequest {

	@NotBlank
	private String episodeName;

	@NotNull
	private int epiLength;

	@NotBlank
	private String location;

	@NotBlank
	private String trailer;
	
	
}
