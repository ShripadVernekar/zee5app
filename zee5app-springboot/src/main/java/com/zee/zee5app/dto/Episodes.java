package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "episodeName") })
public class Episodes {

	@Id
	@Column(name = "epiId")
	private String epiId;

	@NotBlank
	private String episodeName;

	@NotNull
	private int epiLength;

	@NotBlank
	private String location;

	@NotBlank
	private String trailer;

	@ManyToOne
	// this episode table should have fk.seriesid
	@JoinColumn(name = "seriesid")
	private Series Series;   //series id and that col shd act as fk
}
