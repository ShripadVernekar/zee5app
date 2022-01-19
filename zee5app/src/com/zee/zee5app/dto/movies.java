package com.zee.zee5app.dto;

import lombok.Data;

@Data

public class movies {
	
	private String id;
	private String movieName;
	private String category;
	private String language;
	private String releaseDate;
	private float length;
	private String trailer;
	private String[] cast;

}
