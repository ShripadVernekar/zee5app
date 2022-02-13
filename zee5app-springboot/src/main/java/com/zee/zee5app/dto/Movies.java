package com.zee.zee5app.dto;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
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
//@AllArgsConstructor
@Entity // entity class is used for ORM
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "movieName") }, name = "movies") // can be done this

public class Movies implements Comparable<Movies> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movId")
	private Long id;

	@NotBlank
	private String movieName;

	@Max(value = 70)
	private int ageLimit;

	@NotBlank
	private String genre;

	@NotBlank
	private String language;

//	@Lob
//	private byte[] trailer;
	
	private String trailer;

	@NotBlank
	private String cast;

	@NotNull
	private int length;

	@NotBlank
	private String releaseDate;

	@Override
	public int compareTo(Movies o) {
		return o.id.compareTo(this.getId());
	}

	public Movies(String movieName, int ageLimit, String genre, String language, String trailer, String cast,
			int length, String releaseDate) {
		// TODO Auto-generated constructor stub
		this.movieName = movieName;
		this.ageLimit = ageLimit;
		this.genre = genre;
		this.language = language;
		this.trailer = trailer;
		this.cast = cast;
		this.length = length;
		this.releaseDate = releaseDate;
	}

}
