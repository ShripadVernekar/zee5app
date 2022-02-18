package com.learning.payload.request;

import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.learning.dto.FOODTYPE;

import lombok.Data;

@Data
public class FoodRequest {
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
	
}
