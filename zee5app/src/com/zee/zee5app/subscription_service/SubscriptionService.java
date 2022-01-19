package com.zee.zee5app.subscription_service;

import com.zee.zee5app.subscription_dto.subscription;
import com.zee.zee5app.subscription_repoistory.SubscriptionRepoistory;

public class SubscriptionService {
	
	private SubscriptionRepoistory repository = SubscriptionRepoistory.getInstance();
	
	private SubscriptionService() {
		
	}
	
	private static SubscriptionService service = null;
	
	public static SubscriptionService getInstance() {
		
		if(service == null)
			service = new SubscriptionService();
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
