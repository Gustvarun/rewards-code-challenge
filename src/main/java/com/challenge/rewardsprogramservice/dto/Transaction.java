package com.challenge.rewardsprogramservice.dto;

import lombok.Data;

@Data
public class Transaction {
	private String customerId;
	private int dollarsSpent;
	private String transactionDate;
}
