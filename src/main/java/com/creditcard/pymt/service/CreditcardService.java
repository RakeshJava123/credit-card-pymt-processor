package com.creditcard.pymt.service;

import java.util.List;

import com.creditcard.pymt.dto.CustomerProfileTransactionResponse;
import com.creditcard.pymt.dto.ProfileDto;
import com.creditcard.pymt.dto.TransactionDto;

public interface CreditcardService {
	
	public ProfileDto findProfileById(int id);
	public ProfileDto createProfile(ProfileDto profileDto);
	
	public TransactionDto findTransactionById(int id);
	public TransactionDto createTransaction(TransactionDto transactionDto);
	
	public CustomerProfileTransactionResponse findTransactionByProfileId(int profileId);
	
	public CustomerProfileTransactionResponse findTransactionByProfileIdBetweenDates(int profileId, String from, String to) throws Exception;
	
	public List<CustomerProfileTransactionResponse> findLastThreeMonthsTransactionForAllCustomer() throws Exception;

}
