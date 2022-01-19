package com.zee.zee5app.series_dto;

import lombok.Data;

@Data
public class series {

	private String id;
	private String seriesName;
	private String category;
	private String language;
	private String releaseDate;
	private float length;
	private String trailer;
	private String[] cast;
	
}
