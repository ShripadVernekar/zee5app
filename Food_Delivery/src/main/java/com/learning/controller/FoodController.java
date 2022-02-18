package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.FOODTYPE;
import com.learning.dto.Food;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.TypeNotFoundException;
import com.learning.payload.request.FoodRequest;
import com.learning.payload.response.MessageResponse;
import com.learning.repo.FoodRepository;
import com.learning.service.FoodService;

@RestController
@RequestMapping("/api")
public class FoodController {

	@Autowired
	FoodService foodService;
	@Autowired
	FoodRepository foodRepository;

//	@PreAuthorize("hasRole('ROLE_ADMIN')") only admin can do changes

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/food")
	public ResponseEntity<?> addFood(@Valid @RequestBody FoodRequest foodRequest) {

		Food food = new Food(foodRequest.getFoodName(), foodRequest.getFoodCost(), foodRequest.getFoodType(),
				foodRequest.getDescription(), foodRequest.getFoodPic());

		foodRepository.save(food);
		return ResponseEntity.status(201).body(new MessageResponse("Food added successfully"));
	}

	@GetMapping("/food/id/{id}")
	public ResponseEntity<?> getFoodById(@PathVariable("id") int id) throws IdNotFoundException {

		Food food = foodService.getFoodById(id);
		return ResponseEntity.ok(food);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/food/{id}")
	public ResponseEntity<?> updateFood(@PathVariable("id") int id, Food food) throws IdNotFoundException {
		String result = foodService.updateFood(id, food);
		if (result.equals("success"))
			return ResponseEntity.status(200).body(result);
		else {
			Map<String, String> map = new HashMap<>();
			map.put("message : ", "Sorry,user with " + id + " not found");
			return ResponseEntity.status(403).body(map);
		}
	}

	@GetMapping("/food")
	public ResponseEntity<?> getAllFood() {
		Optional<List<Food>> optional = foodService.getAllFoodDetails();

		if (optional.isEmpty()) {
//			return ResponseEntity.ok().body("[]");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok(optional.get());
	}

	@GetMapping("/food/{foodType}")
	public ResponseEntity<?> getFoodByType(@PathVariable("foodType") String foodType) throws TypeNotFoundException {
		FOODTYPE type = FOODTYPE.valueOf(foodType);
		Optional<List<Food>> food = foodService.getFoodByType(type);
		return ResponseEntity.ok(food);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/food/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) throws IdNotFoundException {

		String result = foodService.deleteFoodById(id);
		if (result.equals("success")) {
			return ResponseEntity.ok("food item deleted");
		} else {
			Map<String, String> hashMap = new HashMap<>();
			hashMap.put("message", "Sorry Food Item Not Found");
			return ResponseEntity.badRequest().body(hashMap);
		}
	}

}
