package com.creditcard.pymt.dto;

public class ProfileDto {

	private int profileId;
	private String acctName;
	private String acctNum;
	private String creditCardNum;
	private double creditLimit;
	private double availableCreditLimit;
	private double rewardPointsEarned;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public String getCreditCardNum() {
		return creditCardNum;
	}

	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getAvailableCreditLimit() {
		return availableCreditLimit;
	}

	public void setAvailableCreditLimit(double availableCreditLimit) {
		this.availableCreditLimit = availableCreditLimit;
	}

	public double getRewardPointsEarned() {
		return rewardPointsEarned;
	}

	public void setRewardPointsEarned(double rewardPointsEarned) {
		this.rewardPointsEarned = rewardPointsEarned;
	}

}
