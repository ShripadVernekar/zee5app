package com.zee.zee5app.repoistory;

import com.zee.zee5app.dto.subscription;

public class SubscriptionRepoistory2 {
	
	private subscription[] subscriptionArr = new subscription[10];
	private static int count = -1;
	private static SubscriptionRepoistory2 subscriptionRepoistory;
	
	//update subscription info
	public String updateSubscription(String id, subscription Subscription) {
		int i = 0;
		for(i=0; i< subscriptionArr.length; i++) {
			if(subscriptionArr[i] != null && subscriptionArr[i].getId().equals(id)) {
				subscriptionArr[i] = Subscription;
				return "done";
			}
		}
		return "not found";
	}
	
	//delete Subscription
	public String deleteSubscription(String id) {
		int i = 0;
		for(i=0; i< subscriptionArr.length; i++) {
			if(subscriptionArr[i] != null && subscriptionArr[i].getId().equals(id)) {
				subscriptionArr[i] = subscriptionArr[i+1];
			}
		}
		if(i == subscriptionArr.length)
			return null;
		return "done";
	}
	
	//get Subscription details based on id's
	public subscription getSubscriptionById(String id) {
		 for (subscription Sub : subscriptionArr) {
			 if (Sub !=null && Sub.getId().equals(id))
				 return Sub;
		 }
		 return null;
	}
	
	// to return all Subscription details
	public subscription[] getAllSubscription() {
		return subscriptionArr;
	}
	
	// add a new subscription
	public String addSubscription(subscription Sub) {
		
		if(count == subscriptionArr.length-1) {
			subscription temp[] = new subscription[subscriptionArr.length*2];
			System.arraycopy(subscriptionArr, 0, temp, 0, subscriptionArr.length);
			subscriptionArr = temp;
			subscriptionArr[++count] = Sub;
			return "success";
		}
		
		subscriptionArr[++count] = Sub;
		return "success";
	}
	
	public static SubscriptionRepoistory2 getInstance() {
		if(subscriptionRepoistory==null)
			subscriptionRepoistory = new SubscriptionRepoistory2();
		return subscriptionRepoistory;
	}
	
}
