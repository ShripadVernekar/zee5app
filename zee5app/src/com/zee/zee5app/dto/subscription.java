package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class subscription {
	
	private String type;
	private String id;
	private String status;
	private String dateOfPurchase;
	private String packCountry;
	private String paymentMode;
	private String autoRenewal;
	private String expiryDate;
}
