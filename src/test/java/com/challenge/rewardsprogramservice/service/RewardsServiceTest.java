package com.challenge.rewardsprogramservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.rewardsprogramservice.dto.RewardsSummary;
import com.challenge.rewardsprogramservice.exception.NoTransactionsFoundException;

@SpringBootTest
public class RewardsServiceTest {
	@InjectMocks
	RewardsProgramService rewardsProgramService;
	
	@Test
	public void testGetRewardPointsByUserIdWithValidInput() throws Exception {	
		List<RewardsSummary> response= rewardsProgramService.calculateRewardsForACustomer(3,"123");
		assertTrue(!response.isEmpty());
		assertNotNull(response.size()==2);
	}
	
	@Test
	public void testGetRewardPointsByUserIdWithInValidInput() {
		assertThrows(NoTransactionsFoundException.class, ()-> rewardsProgramService.calculateRewardsForACustomer(3,"456"));			
	}

}
