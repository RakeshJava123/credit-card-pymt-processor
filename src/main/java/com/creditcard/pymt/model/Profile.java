package com.creditcard.pymt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="profile_id")
	private int profileId;
	private String acctName;
	private String acctNum;
	private String creditCardNum;
	private double creditLimit;
	private double availableCreditLimit;
	private double rewardPointsEarned;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
	List<Transaction> Transactions = new ArrayList<>();

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

	public List<Transaction> getTransactions() {
		return Transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		Transactions = transactions;
	}

}
