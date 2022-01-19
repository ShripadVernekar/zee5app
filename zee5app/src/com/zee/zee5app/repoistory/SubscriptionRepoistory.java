package com.zee.zee5app.repoistory;

import com.zee.zee5app.dto.subscription;

public interface SubscriptionRepoistory {
	
	//update subscription info
	public String updateSubscription(String id, subscription Subscription);
	
	//delete Subscription
	public String deleteSubscription(String id);
	
	//get Subscription details based on id's
	public subscription getSubscriptionById(String id);
	
	// to return all Subscription details
	public subscription[] getAllSubscription();
	
	// add a new subscription
	public String addSubscription(subscription Sub);
	
	
}
