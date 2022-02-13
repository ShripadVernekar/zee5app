package com.zee.zee5app.payload.request;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.dto.Episodes;

import lombok.Data;

@Data

public class SeriesRequest {


	@Max(value = 70)
	private int ageLimit;

	@NotBlank
	private String seriesName;

	@NotBlank
	private String genre;

	@NotBlank
	private String language;

	@NotNull
	private String releaseDate;

	@NotBlank
	private String trailer;

	@NotBlank
	private String cast;

	@Min(value = 1)
	private int noOfEpisodes;
	
	private List<Episodes> episodes;
}
