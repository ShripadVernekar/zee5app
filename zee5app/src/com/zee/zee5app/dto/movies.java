package com.zee.zee5app.dto;

import javax.naming.InvalidNameException;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
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

public class movies implements Comparable<movies>{
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String movieName;
	private String category;
	private String language;
	private String releaseDate;
	private float length;
	private String trailer;
	private String[] cast;
	private String[] allowedLocations;
	
	
	public movies(String id, String movieName, String category, String language,
			String releaseDate, float length, String trailer, String[] cast, String[] allowedLocations) 
			throws InvalidNameException, InvalidIdLengthException 
	{
		
		super();
		this.setId(id);
		this.setMovieName(movieName);
		this.category = category;
		this.language = language;
		this.releaseDate = releaseDate;
		this.length = length;
		this.trailer = trailer;
		this.cast = cast;
		this.allowedLocations = allowedLocations;
	}
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length() < 6) {
			//raise invalidId exception
			//exception obj is created by jvm but here we have to create & raise user defined exception obj
			throw new InvalidIdLengthException("id length is less than or equal to 6"); //throws exception
		}
		this.id = id;
	}
	
	public void setMovieName(String movieName) throws InvalidNameException {
		if (movieName == null || movieName == "" || movieName.length() <2) {
			throw new InvalidNameException("Movie name not valid");
		}
		this.movieName = movieName;
	}
	
	@Override
	public int compareTo(movies o) {
		// TODO Auto-generated method stub
//		ascending order
//		return this.id.compareTo(o.getId());
//		descending order
		return o.id.compareTo(this.getId());
	}

}
