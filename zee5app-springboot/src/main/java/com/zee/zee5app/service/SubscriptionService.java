package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SubscriptionService {
	
	//update subscription info
		public String updateSubscription(String id, Subscription subscription) throws IdNotFoundException;
		
		//delete Subscription
		public String deleteSubscription(String id) throws IdNotFoundException;
		
		//get Subscription details based on id's
		public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException;
		
		// to return all Subscription details
		public Optional<List<Subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException;
		
		// add a new subscription
		public String addSubscription(Subscription subscription);
	
}