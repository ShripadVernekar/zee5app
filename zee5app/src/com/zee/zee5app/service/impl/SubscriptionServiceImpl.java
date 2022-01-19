package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.repoistory.SubscriptionRepoistory;
import com.zee.zee5app.repository.impl.SubscriptionRepoistoryImpl;
import com.zee.zee5app.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	private static SubscriptionService subscriptionService;
	
	public static SubscriptionService getInstance() {
		if(subscriptionService == null)
			subscriptionService = new SubscriptionServiceImpl();
		return subscriptionService;
	}
	
	SubscriptionRepoistory subscriptionRepoistory = SubscriptionRepoistoryImpl.getInstance();

	@Override
	public String addSubscription(subscription Subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.addSubscription(Subscription);
	}

	@Override
	public subscription getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.getSubscriptionById(id);
	}

	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.deleteSubscription(id);
	}

	@Override
	public String updateSubscription(String id, subscription Subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.updateSubscription(id, Subscription);
	}

	@Override
	public subscription[] getAllSubscription() {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.getAllSubscription();
	}

}
