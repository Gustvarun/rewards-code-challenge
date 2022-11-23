package com.challenge.rewardsprogramservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardsSummary {
	private int rewardPoints;
	private String month;
}
