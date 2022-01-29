package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repoistory.SubscriptionRepoistory;
import com.zee.zee5app.repoistory.impl.SubscriptionRepoistoryImpl;
import com.zee.zee5app.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	
	private static SubscriptionService subscriptionService;
	private static SubscriptionRepoistory subscriptionRepoistory;
	
	private SubscriptionServiceImpl() throws IOException {
		subscriptionRepoistory = SubscriptionRepoistoryImpl.getInstance();
	}
	
	public static SubscriptionService getInstance() throws IOException {
		if(subscriptionService == null)
			subscriptionService = new SubscriptionServiceImpl();
		return subscriptionService;
	}
	
	

	@Override
	public String addSubscription(subscription Subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.addSubscription(Subscription);
	}

	@Override
	public Optional<subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
		return subscriptionRepoistory.getSubscriptionById(id);
	}
	

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.deleteSubscription(id);
	}

	@Override
	public String updateSubscription(String id, subscription Subscription) throws IdNotFoundException {
		return subscriptionRepoistory.updateSubscription(id, Subscription);
	}

	@Override
	public Optional<ArrayList<subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.getAllSubscription();
	}

}
