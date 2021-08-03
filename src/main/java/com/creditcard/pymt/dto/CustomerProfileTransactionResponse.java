package com.creditcard.pymt.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerProfileTransactionResponse {
	
	public int profileId;
	public String acctName;
	public String acctNum;
	public String creditCardNum;
	public double creditLimit;
	public double availableCreditLimit;
	public double rewardPointsEarned;
	
	public List<TransactionResponse> transactions;

}
