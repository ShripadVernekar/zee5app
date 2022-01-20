package com.zee.zee5app.repoistory.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.repoistory.SubscriptionRepoistory;

public class SubscriptionRepoistoryImpl implements SubscriptionRepoistory {

//	private subscription[] subscriptionArr = new subscription[10];
//	private static int count = -1;

	private ArrayList<subscription> arrayList = new ArrayList<>();
	private static SubscriptionRepoistory subscriptionRepoistory;
	
	private SubscriptionRepoistoryImpl() {
		
	}
	
	public static SubscriptionRepoistory getInstance() {
		if (subscriptionRepoistory == null)
			subscriptionRepoistory = new SubscriptionRepoistoryImpl();
		return subscriptionRepoistory;
	}

	@Override
	public String updateSubscription(String id, subscription Subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<subscription> getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		subscription sub2 = null;
		 for (subscription Sub : arrayList) {
		 if (Sub.getId().equals(id))
			 sub2 = Sub;
	 }
	 return Optional.ofNullable(sub2);
	}

	@Override
	public subscription[] getAllSubscription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addSubscription(subscription Sub) {
		// TODO Auto-generated method stub
		boolean res = this.arrayList.add(Sub);
		if(res) {
			return "success";
		}
		return "failed";
	}

	
	
//	@Override
//	public String updateSubscription(String id, subscription Subscription) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		for(i=0; i< subscriptionArr.length; i++) {
//			if(subscriptionArr[i] != null && subscriptionArr[i].getId().equals(id)) {
//				subscriptionArr[i] = Subscription;
//				return "done";
//			}
//		}
//		return "not found";
//	}
//
//	@Override
//	public String deleteSubscription(String id) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		for(i=0; i< subscriptionArr.length; i++) {
//			if(subscriptionArr[i] != null && subscriptionArr[i].getId().equals(id)) {
//				subscriptionArr[i] = subscriptionArr[i+1];
//			}
//		}
//		if(i == subscriptionArr.length)
//			return null;
//		return "done";
//	}
//
//	@Override
//	public subscription getSubscriptionById(String id) {
//		// TODO Auto-generated method stub
//		 for (subscription Sub : subscriptionArr) {
//			 if (Sub !=null && Sub.getId().equals(id))
//				 return Sub;
//		 }
//		 return null;
//	}
//
//	@Override
//	public subscription[] getAllSubscription() {
//		// TODO Auto-generated method stub
//		return subscriptionArr;
//	}
//
//	@Override
//	public String addSubscription(subscription Sub) {
//		// TODO Auto-generated method stub
//		if(count == subscriptionArr.length-1) {
//			subscription temp[] = new subscription[subscriptionArr.length*2];
//			System.arraycopy(subscriptionArr, 0, temp, 0, subscriptionArr.length);
//			subscriptionArr = temp;
//			subscriptionArr[++count] = Sub;
//			return "success";
//		}
//		
//		subscriptionArr[++count] = Sub;
//		return "success";
//	}
	

}
