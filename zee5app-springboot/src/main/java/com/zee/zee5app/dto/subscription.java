package com.zee.zee5app.dto;


import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class subscription {
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	private String dateOfPurchase;
	private String expiryDate;
	@Setter(value = AccessLevel.NONE)
	private int amount;
	private String paymentMode;
	private String status;
	private String type;
	private String autoRenewal;
	private String regId;
	
	
	public subscription(String id, String type, String status, String dateOfPurchase,int amount,
			String regId, String paymentMode, String autoRenewal, String expiryDate) 
			throws InvalidIdLengthException, InvalidAmountException 
	{
		
		super();
		this.setId(id);
		this.type = type;
		this.status = status;
		this.dateOfPurchase = dateOfPurchase;
		this.setAmount(amount);
		this.regId = regId;
		this.paymentMode = paymentMode;
		this.autoRenewal = autoRenewal;
		this.expiryDate = expiryDate;
	}
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length() < 6) {
			//raise invalidId exception
			//exception obj is created by jvm but here we have to create & raise user defined exception obj
			throw new InvalidIdLengthException("id length is less than or equal to 6"); //throws exception
		}
		this.id = id;
	}
	
	public void setAmount(int amount) throws InvalidAmountException{
		float fixAmt = 1000.0f;
		if(amount < fixAmt) {
			throw new InvalidAmountException("Amount not sufficient");
		}
		this.amount = amount;
	}
	
}
