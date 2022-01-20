package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.subscription;

public interface SubscriptionService {
	
	public String addSubscription(subscription Subscription);
	
	public Optional<subscription> getSubscriptionById(String id);
	
	public String deleteSubscription(String id);
	
	public String updateSubscription(String id, subscription Subscription);
	
	public subscription[] getAllSubscription();
	
}
