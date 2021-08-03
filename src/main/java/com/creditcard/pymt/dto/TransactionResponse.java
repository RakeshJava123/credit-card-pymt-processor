package com.creditcard.pymt.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TransactionResponse {

	public int transactionId;
	public double amountSpent;
	public Date transactionDate;
	public double rewardPoints;
}
