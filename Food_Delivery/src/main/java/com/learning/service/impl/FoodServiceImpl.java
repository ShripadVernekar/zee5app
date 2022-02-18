package com.learning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.TypeNotFoundException;
import com.learning.repo.FoodRepository;
import com.learning.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	FoodRepository foodRepository;

	@Override
	public Food addFood(Food food) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		
		if (foodRepository.existsById(food.getId()) == true) {
			throw new AlreadyExistsException("This record exists in DB");
		}
		
		Food food2 = foodRepository.save(food);
		if (food2 != null) {
			return food2;
		} else {
				return null;
		}
	}

	@Override
	public String updateFood(int id, Food food) throws IdNotFoundException {
		if(!this.foodRepository.existsById(id)) {
			throw new IdNotFoundException("Invalid Id");
		}
		food.setId(id);
		if (this.foodRepository.save(food)!=null){
			return "success" ; 
		}else {
			return "failure";
		}
		
	}

	@Override
	public Food getFoodById(Integer id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Food> optional = foodRepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Sorry Food Not Found");
		} else {
			return optional.get();
		}
	}
	
	@Override
	public Optional<List<Food>> getFoodByType(FOODTYPE type) throws TypeNotFoundException {
		
		return Optional.ofNullable(foodRepository.findAllByfoodType(type));
	}

	@Override
	public Optional<List<Food>> getAllFoodDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(foodRepository.findAll());
	}

	@Override
	public String deleteFoodById(Integer id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Food optional;
		try {
			optional = this.getFoodById(id);
			if (optional == null) {
				throw new IdNotFoundException("Sorry Food Item Not Found");
			} else {
				foodRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}

	}

	
}
