package com.zee.zee5app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "seriesName") })

public class Series implements Comparable<Series> {

	@Id
	@Column(name = "seriesId")
	private Long id;

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


	public Series( int ageLimit,  String seriesName,  String genre,
			 String language, String trailer,  String cast,
			int noOfEpisodes, String releaseDate, List<Episodes> episodes) {
		
		this.ageLimit = ageLimit;
		this.seriesName = seriesName;
		this.genre = genre;
		this.language = language;
		this.trailer = trailer;
		this.cast = cast;
		this.noOfEpisodes = noOfEpisodes;
		this.releaseDate = releaseDate;
		this.episodes = episodes;
	}

	@Override
	public int compareTo(Series o) {
		return o.id.compareTo(this.getId());
	}
	


	@OneToMany(mappedBy = "Series", cascade = CascadeType.ALL)
	private List<Episodes> episodes = new ArrayList<>();
	
}
