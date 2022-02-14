package com.assessment.retailer.rewardsprogram.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.retailer.rewardsprogram.Entity.RetailTransaction;
import com.assessment.retailer.rewardsprogram.Entity.Rewards;
import com.assessment.retailer.rewardsprogram.Repository.RewardsProgramRepository;

@Service
public class RewardsProgramService {
	@Autowired
	private RewardsProgramRepository rewardsRepository;
	public List<Rewards> getCustomerRewards() {
		List< Rewards> customerRewards=new ArrayList<>();
		for(int customerId: rewardsRepository.findCustomer()) {			
			customerRewards.add(getRewardsByCustomerId(customerId));					
		}
		
		return customerRewards;
	}

	public List<RetailTransaction> getRetailTransactionData() {
		return rewardsRepository.findAll();
	}
	 
	public Rewards getRewardsByCustomerId(int customerId) {
		return new Rewards(customerId,calculateRewards(rewardsRepository.findRewardsByCustomerIdAndAmountGreaterThan(customerId,50)));
	}

	private Map<String, Integer> calculateRewards(List<RetailTransaction> transactionList) {
		int rewardTotal=0;
		int transactionamt=0;
		int totalamount=0;
		String transactionMonth;
		Map<String,Integer> myRewardMap=new TreeMap<String,Integer>();
		
		for(RetailTransaction transaction: transactionList) {
			transactionamt=Math.round(transaction.getAmount());
			rewardTotal=(transactionamt<=100)?(transactionamt-50):2*(transactionamt-100)+50;
			transactionMonth=transaction.getDate().getMonth().toString();
			if(!myRewardMap.containsKey(transactionMonth)){
				myRewardMap.put(transactionMonth,0);
			}
			
			myRewardMap.put(transactionMonth, myRewardMap.get(transactionMonth)+rewardTotal);		
			totalamount+=rewardTotal;
		}
		
		myRewardMap.put("Total", totalamount);
		
		return myRewardMap;
	}

}
