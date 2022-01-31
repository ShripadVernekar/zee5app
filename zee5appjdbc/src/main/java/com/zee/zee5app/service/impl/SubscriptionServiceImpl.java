package com.zee.zee5app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repoistory.SubscriptionRepoistory;
import com.zee.zee5app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	private static SubscriptionRepoistory subscriptionRepoistory;

	@Override
	public String addSubscription(subscription Subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.addSubscription(Subscription);
	}

	@Override
	public Optional<subscription> getSubscriptionById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
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
	public Optional<ArrayList<subscription>> getAllSubscription()
			throws InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return subscriptionRepoistory.getAllSubscription();
	}

}
