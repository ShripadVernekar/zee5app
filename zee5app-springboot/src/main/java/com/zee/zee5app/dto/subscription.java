package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity 
@Table(name = "subscription")

public class subscription implements Comparable<subscription>{
	
	@Id
	@Column(name = "subId")
	private String id;
	
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
	
	@NotBlank
	private String regId;

	@Override
	public int compareTo(subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	
}
