package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private  SubscriptionRepository subscriptionRepository;

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Subscription sub = subscriptionRepository.save(subscription);
		if(sub != null) {
			return "success";
		}else {
			return "fail";
		}
	}

	@Override
	public String deleteSubscription(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional;
		try {
			optional = this.getSubscriptionById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			}else {
				subscriptionRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public Optional<Subscription> getSubscriptionById(Long id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(id);
	}

	@Override
	public Optional<List<Subscription>> getAllSubscription() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subscriptionRepository.findAll());
	}

	@Override
	public String updateSubscription(Long id, Subscription subscription) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
