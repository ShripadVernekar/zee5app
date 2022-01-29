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

public class series implements Comparable<series> {

	@Setter(value = AccessLevel.NONE)
	private String id;
	private int ageLimit;
	private String genre;
	private String language;
	private String releaseDate;
	private int length;
	private String trailer;
	private String cast;
	private int noOfEpisodes;

	public series(String id, int ageLimit, String genre, String language, String releaseDate, int length,
			String trailer, String cast, int noOfEpisodes) throws InvalidNameException, InvalidIdLengthException {

		super();
		this.setId(id);
		this.ageLimit = (ageLimit);
		this.cast = cast;
		this.genre = genre;
		this.length = length;
		this.trailer = trailer;
		this.releaseDate = releaseDate;
		this.language = language;
		this.noOfEpisodes = noOfEpisodes;

	}

//	set Id
	public void setId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6"); // throws exception
		}
		this.id = id;
	}

	@Override
	public int compareTo(series o) {
		return o.id.compareTo(this.getId());
	}

}
