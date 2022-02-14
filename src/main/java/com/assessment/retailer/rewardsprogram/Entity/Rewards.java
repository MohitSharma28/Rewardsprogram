package com.assessment.retailer.rewardsprogram.Entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rewards {
	private int customerId;
	private Map<String,Integer> cusomterRewardsMap;
}
