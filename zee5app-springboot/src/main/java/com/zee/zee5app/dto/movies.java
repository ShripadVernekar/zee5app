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

public class movies implements Comparable<movies> {

	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String movieName;
	private int ageLimit;
	private String genre;
	private String language;
	private String trailer;
	private String cast;
	private int length;
	private String releaseDate;

	public movies(String id, String movieName, String genre, String language, String releaseDate, int length,
			String trailer, String cast, int ageLimit) throws InvalidNameException, InvalidIdLengthException {

		super();
		this.setId(id);
		this.setMovieName(movieName);
		this.ageLimit = ageLimit;
		this.genre = genre;
		this.language = language;
		this.trailer = trailer;
		this.cast = cast;
		this.length = length;
		this.releaseDate = releaseDate;

	}

	public void setId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6"); // throws exception
		}
		this.id = id;
	}

	public void setMovieName(String movieName) throws InvalidNameException {
		if (movieName == null || movieName == "" || movieName.length() < 2) {
			throw new InvalidNameException("Movie name not valid");
		}
		this.movieName = movieName;
	}

	@Override
	public int compareTo(movies o) {
		return o.id.compareTo(this.getId());
	}

}
