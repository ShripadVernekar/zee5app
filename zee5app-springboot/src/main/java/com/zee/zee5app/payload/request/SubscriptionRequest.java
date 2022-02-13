package com.zee.zee5app.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SubscriptionRequest {

	@NotNull
	private String dateOfPurchase;
	@NotNull
	private String expiryDate;
	
	@NotNull
	private int amount;
	
	@NotBlank
	private String paymentMode;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String type;
	
	@NotBlank
	private String autoRenewal;
}
