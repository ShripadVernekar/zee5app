package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.TypeNotFoundException;

public interface FoodService {

  	public Food addFood(Food food) throws AlreadyExistsException;
	public String updateFood(int id, Food food) throws IdNotFoundException;
	public Food getFoodById(Integer id) throws IdNotFoundException;
	public Optional<List<Food>> getAllFoodDetails() ;
	public String deleteFoodById(Integer id) throws IdNotFoundException;
	public Optional<List<Food>> getFoodByType(FOODTYPE type) throws TypeNotFoundException ;
}
