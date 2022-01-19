package com.zee.zee5app.service;

import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.repoistory.SubscriptionRepoistory;

public class SubscriptionService2 {
	
	private SubscriptionRepoistory repository = SubscriptionRepoistory.getInstance();
	
	private SubscriptionService2() {
		
	}
	
	private static SubscriptionService2 service = null;
	
	public static SubscriptionService2 getInstance() {
		
		if(service == null)
			service = new SubscriptionService2();
		return service;
	}
	
	public String addSubscription(subscription Subscription) {
		return this.repository.addSubscription(Subscription);
	}
	
	public subscription getSubscriptionById(String id) {
		return this.repository.getSubscriptionById(id);
	}
	
	public String deleteSubscription(String id) {
		return this.repository.deleteSubscription(id);
	}
	
	public String updateSubscription(String id, subscription Subscription) {
		return this.repository.updateSubscription(id, Subscription);
	}
	
	public subscription[] getAllSubscription() {
		return this.repository.getAllSubscription();
	}
	
}
