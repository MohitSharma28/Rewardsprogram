package com.assessment.retailer.rewardsprogram;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.assessment.retailer.rewardsprogram.Entity.Rewards;

@SpringBootTest
class RewardsprogramApplicationTests {

	@Test
	void contextLoads() {
	}
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getRewardsByCustomerTest() throws Exception {
		
		ResponseEntity<Rewards> myRewards=this.restTemplate.getForEntity("http://localhost:" + port + "/rewards/1",
				Rewards.class);
		
		assertEquals(HttpStatus.OK, myRewards.getStatusCode());
		assertThat(myRewards.getBody().getCustomerId()==1);
		assertThat(388).isEqualTo(myRewards.getBody().getCusomterRewardsMap().get("AUGUST"));
		assertThat(854).isEqualTo(myRewards.getBody().getCusomterRewardsMap().get("JULY"));
		assertThat(2290).isEqualTo(myRewards.getBody().getCusomterRewardsMap().get("SEPTEMBER"));
		assertThat(3532).isEqualTo(myRewards.getBody().getCusomterRewardsMap().get("Total"));
		
	}
	
	@Test
	public void getRewardsByCustomerTest1() throws Exception {
		
		ResponseEntity<Rewards> myRewards=this.restTemplate.getForEntity("http://localhost:" + port + "/rewards/2",
				Rewards.class);
		
		assertEquals(HttpStatus.OK, myRewards.getStatusCode());
		assertThat(myRewards.getBody().getCustomerId()==1);
		assertThat(39).isEqualTo(myRewards.getBody().getCusomterRewardsMap().get("AUGUST"));
		assertThat(754).isEqualTo(myRewards.getBody().getCusomterRewardsMap().get("JULY"));
		assertThat(1745).isEqualTo(myRewards.getBody().getCusomterRewardsMap().get("SEPTEMBER"));
		assertThat(2538).isEqualTo(myRewards.getBody().getCusomterRewardsMap().get("Total"));
		
	}
	
	@Test
	public void getRewardsTest() throws Exception {
		
		ResponseEntity<Rewards[]> myRewards=this.restTemplate.getForEntity("http://localhost:" + port + "/rewards",
				Rewards[].class);
		
		Rewards[] myRewardList=myRewards.getBody();
		
		assertEquals(HttpStatus.OK, myRewards.getStatusCode());
		assertThat(myRewardList.length>0);
		assertThat(myRewardList[1].getCustomerId()==3);
		assertThat(2242).isEqualTo(myRewardList[1].getCusomterRewardsMap().get("AUGUST"));
		assertThat(868).isEqualTo(myRewardList[1].getCusomterRewardsMap().get("JULY"));
		assertThat(895).isEqualTo(myRewardList[1].getCusomterRewardsMap().get("SEPTEMBER"));
		assertThat(4005).isEqualTo(myRewardList[1].getCusomterRewardsMap().get("Total"));
		
	}

}
