package com.zee.zee5app.repoistory;

import java.util.Optional;

import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;

public interface SubscriptionRepoistory {
	
	//update subscription info
	public String updateSubscription(String id, subscription Subscription) throws IdNotFoundException;
	
	//delete Subscription
	public String deleteSubscription(String id) throws IdNotFoundException;
	
	//get Subscription details based on id's
	public Optional<subscription> getSubscriptionById(String id) throws IdNotFoundException;
	
	// to return all Subscription details
	public subscription[] getAllSubscription();
	
	// add a new subscription
	public String addSubscription(subscription Sub);
	
	
}
