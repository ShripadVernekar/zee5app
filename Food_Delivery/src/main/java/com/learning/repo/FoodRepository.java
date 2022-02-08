package com.learning.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Food;


@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	Optional<Food> findByfoodType(Enum<FOODTYPE> foodType);
}
