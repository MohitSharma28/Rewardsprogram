package com.assessment.retailer.rewardsprogram.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.retailer.rewardsprogram.Entity.RetailTransaction;
import com.assessment.retailer.rewardsprogram.Entity.Rewards;
import com.assessment.retailer.rewardsprogram.Service.RewardsProgramService;


@RestController
@RequestMapping("/rewards")
public class RewardsProgramController {
	@Autowired
	private RewardsProgramService rewardsService;
	
	/**
	 * Reward details for all customers.
	 * @return rewards for all customers
	 */
	@GetMapping
	public List<Rewards> getRewards() {
		return rewardsService.getCustomerRewards();
	}
	
	/**
	 * Reward details for specified customer id
	 * @param custId
	 * @return rewards for specified customer id
	 */
	@GetMapping("/{customerId}")
	public Rewards getRewardsByCustomer(@PathVariable("customerId") int custId){
		return rewardsService.getRewardsByCustomerId(custId);
	}
	
	
	/**
	 * Lists all transactions in DB
	 * @return all transactions in table
	 */
	@GetMapping("/transactions")
	public List<RetailTransaction> getTransactions() {
		return rewardsService.getRetailTransactionData();
	}
}
