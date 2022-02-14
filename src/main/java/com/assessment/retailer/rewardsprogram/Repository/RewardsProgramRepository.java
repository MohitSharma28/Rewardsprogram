package com.assessment.retailer.rewardsprogram.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assessment.retailer.rewardsprogram.Entity.RetailTransaction;

@Repository
public interface RewardsProgramRepository extends JpaRepository<RetailTransaction, Long> {

		List<RetailTransaction> findRewardsByCustomerIdAndAmountGreaterThan(int customerId,float transaction); 
		
		@Query("SELECT DISTINCT customerId FROM RetailTransaction")
	    List<Integer> findCustomer();

}
