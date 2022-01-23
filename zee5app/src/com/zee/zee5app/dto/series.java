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

public class series implements Comparable<series>{

	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String seriesName;
	private String category;
	private String language;
	private String releaseDate;
	private float length;
	private String trailer;
	private String[] cast;
	
	public series(String id, String seriesName, String category, String language,
			String releaseDate, float length, String trailer, String[] cast) 
			throws InvalidNameException, InvalidIdLengthException 
	{
		
		super();
		this.setId(id);
		this.setSeriesName(seriesName);
		this.category = category;
		this.language = language;
		this.releaseDate = releaseDate;
		this.length = length;
		this.trailer = trailer;
		this.cast = cast;
	}
	
//	set Id
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length() < 6) {
			//raise invalidId exception
			//exception obj is created by jvm but here we have to create & raise user defined exception obj
			throw new InvalidIdLengthException("id length is less than or equal to 6"); //throws exception
		}
		this.id = id;
	}
	
	public void setSeriesName(String seriesName) throws InvalidNameException {
		if (seriesName == null || seriesName == "" || seriesName.length() <2) {
			throw new InvalidNameException("Series name not valid");
		}
		this.seriesName = seriesName;
	}

	@Override
	public int compareTo(series o) {
		// TODO Auto-generated method stub

		return o.id.compareTo(this.getId());
	}
	
}
