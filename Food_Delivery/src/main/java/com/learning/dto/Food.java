package com.learning.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "foodname")})
public class Food {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	@Size(max = 50)
	@NotBlank
	private String foodName;

	@NotNull
	private int foodCost;

	@Enumerated(EnumType.STRING)
	@NotNull
	private FOODTYPE foodType;

	@Size(max = 80)
	@NotBlank
	private String description;

	@Size(max = 50)
	@NotBlank
	private String foodPic;

	public Food(String foodName, int foodCost, FOODTYPE foodType, String description, String foodPic) {
		this.foodName = foodName;
		this.foodCost = foodCost;
		this.foodType = foodType;
		this.description = description;
		this.foodPic = foodPic;
	}
	

}
