package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
//@AllArgsConstructor
@Entity 
@Table(name = "subscription")

public class Subscription implements Comparable<Subscription>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subId")
	private Long id;
	
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

	

	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}



	public Subscription(String dateOfPurchase, String expiryDate, int amount,
			String paymentMode, String status, String type,
			String autoRenewal) {
		this.dateOfPurchase = dateOfPurchase;
		this.expiryDate = expiryDate;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.status = status;
		this.type = type;
		this.autoRenewal = autoRenewal;
	}
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JsonProperty(access = Access.WRITE_ONLY)
//	@JoinColumn(name = "regid")
//	private User register;
	
}
