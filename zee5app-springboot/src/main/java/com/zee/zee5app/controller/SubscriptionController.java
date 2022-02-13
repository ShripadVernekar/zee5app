package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.payload.request.SubscriptionRequest;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;

@RestController

@RequestMapping("/api/subcriptions")
public class SubscriptionController {

	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addsubsciption")
	public ResponseEntity<?> addSubsciption(@Valid @RequestBody SubscriptionRequest subscriptionRequest){
		
		Subscription subscription = new Subscription(subscriptionRequest.getDateOfPurchase(),
				subscriptionRequest.getExpiryDate(), subscriptionRequest.getAmount(),
				subscriptionRequest.getPaymentMode(), subscriptionRequest.getStatus(), 
				subscriptionRequest.getType(), subscriptionRequest.getAutoRenewal());
		
		subscriptionRepository.save(subscription);
		return ResponseEntity.status(201).body(new MessageResponse("Subscription created successfully"));
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/getsubscription/{id}")
	public ResponseEntity<?> getSubscription(@PathVariable("id") Long id){
		if (subscriptionRepository.existsById(id)) {
			Optional<Subscription> subscription = subscriptionRepository.findById(id);
			return ResponseEntity.ok(subscription);
		}
		return ResponseEntity.badRequest()
				 .body(new MessageResponse("Error: Subscription with id: "+id+" does not exists!"));
	}
	
	@PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<?> getAllSubscriptions() {
		Optional<List<Subscription>> optional = subscriptionService.getAllSubscription();
		
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No record found"));
		}
		return ResponseEntity.ok(optional.get());
	}
	
}
