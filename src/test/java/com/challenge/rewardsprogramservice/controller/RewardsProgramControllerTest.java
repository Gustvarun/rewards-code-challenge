package com.challenge.rewardsprogramservice.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.challenge.rewardsprogramservice.dto.RewardsSummary;
import com.challenge.rewardsprogramservice.exception.NoTransactionsFoundException;
import com.challenge.rewardsprogramservice.service.RewardsProgramService;

@SpringBootTest
public class RewardsProgramControllerTest {
	
	@InjectMocks
	RewardsProgramController rewardsProgramController;
	
	@Mock
	RewardsProgramService rewardsProgramService;
	
	
	
	@Test
	public void testGetRewardPointsByUserIdWithValidInput() throws Exception {
		Mockito.when(rewardsProgramService.calculateRewardsForACustomer(Mockito.anyInt(), Mockito.anyString())).thenReturn(getMockRewardsSummary());
		ResponseEntity<?> response= rewardsProgramController.getRewardPointsByUserId("123", 3);
		assertTrue(response.getStatusCode().value()==200);
		assertNotNull(response.getBody());
	}
	
	private List<RewardsSummary> getMockRewardsSummary() {
		List<RewardsSummary> rewardsSummaries = new ArrayList<>();
		RewardsSummary rewardsSummary =RewardsSummary.builder()
				.month("NOVEMBER")
				.rewardPoints(100)
				.build();
		rewardsSummaries.add(rewardsSummary);
		
		return rewardsSummaries;
	}

	@Test
	public void testGetRewardPointsByUserIdWithInValidInput() throws Exception {
		Mockito.when(rewardsProgramService.calculateRewardsForACustomer(Mockito.anyInt(), Mockito.anyString())).thenThrow(new NoTransactionsFoundException());
		ResponseEntity<?> response= rewardsProgramController.getRewardPointsByUserId("789", 3);
		assertTrue(response.getStatusCode().value()==400);		
	}

}
