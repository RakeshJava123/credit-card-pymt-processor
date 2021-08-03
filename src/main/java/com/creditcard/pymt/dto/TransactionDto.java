package com.creditcard.pymt.dto;

import java.util.Date;

public class TransactionDto {

	private int transactionId;

	private double amountSpent;

	private Date transactionDate;

	private double rewardPoints;

	private int profileId;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(double rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

}
