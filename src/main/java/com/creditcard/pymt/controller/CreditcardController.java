package com.creditcard.pymt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.pymt.dto.CustomerProfileTransactionResponse;
import com.creditcard.pymt.dto.ProfileDto;
import com.creditcard.pymt.dto.TransactionDto;
import com.creditcard.pymt.service.CreditcardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CreditcardController {

	@Autowired
	private CreditcardService creditcardService;

	@GetMapping(value="/profile/{id}",produces="application/json")
	public ProfileDto getProfileById(@PathVariable int id) {
		return creditcardService.findProfileById(id);
	}

	@PostMapping(value="/profile/create",consumes="application/json",produces="application/json")
	public ProfileDto createProfile(@RequestBody ProfileDto profile) {
		return creditcardService.createProfile(profile);
	}
	
	@GetMapping(value="/transaction/{transactionid}",produces="application/json")
	public TransactionDto getTransactionById(@PathVariable int transactionid) {
		return creditcardService.findTransactionById(transactionid);
	}

	@PostMapping(value="/transaction/create",consumes="application/json",produces="application/json")
	public TransactionDto createTransaction(@RequestBody TransactionDto transaction) {
		return creditcardService.createTransaction(transaction);
	}
	
	@GetMapping(value="/transaction/profileid/{profileid}",produces="application/json")
	public CustomerProfileTransactionResponse getTransactionByProfileId(@PathVariable int profileid) {
		return creditcardService.findTransactionByProfileId(profileid);
	}
	
	@GetMapping(value="/transaction/profileid/{profileid}/period",produces="application/json")
	public CustomerProfileTransactionResponse getTransactionByProfileIdForGivenPeriod(@PathVariable int profileid,@RequestParam String from, @RequestParam String to) throws Exception {
		return creditcardService.findTransactionByProfileIdBetweenDates(profileid, from, to);
	}
	
	@GetMapping(value="/transaction/last/threemonth/all",produces="application/json")
	public List<CustomerProfileTransactionResponse> getLastThreeMonthsTransactionForAllCustomer() throws Exception {
		return creditcardService.findLastThreeMonthsTransactionForAllCustomer();
	}

}
