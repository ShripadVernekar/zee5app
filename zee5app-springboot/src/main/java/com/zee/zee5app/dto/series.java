package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@AllArgsConstructor
@Entity // entity class is used for ORM
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "seriesName") })

public class series implements Comparable<series> {

	@Id
	@Column(name = "seriesId")
	private String id;

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

	@Override
	public int compareTo(series o) {
		return o.id.compareTo(this.getId());
	}

}
