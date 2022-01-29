package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;

public interface SubscriptionService {
	
	public String addSubscription(subscription Subscription);
	
	public Optional<subscription> getSubscriptionById(String id) throws IdNotFoundException;
		
	public String deleteSubscription(String id) throws IdNotFoundException;
	
	public String updateSubscription(String id, subscription Subscription) throws IdNotFoundException;
	
	public subscription[] getAllSubscription();
	
}
