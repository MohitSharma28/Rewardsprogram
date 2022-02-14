package com.assessment.retailer.rewardsprogram.Entity;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RetailTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long transactionId;
	private int customerId;
	private float amount;
	private LocalDate date;

}
