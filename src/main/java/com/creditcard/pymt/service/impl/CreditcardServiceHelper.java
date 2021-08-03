package com.creditcard.pymt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditcard.pymt.dto.CustomerProfileTransactionResponse;
import com.creditcard.pymt.dto.TransactionResponse;
import com.creditcard.pymt.model.Transaction;

@Component
public class CreditcardServiceHelper {

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * 
	 * @param transactions
	 * @return
	 */
	public List<CustomerProfileTransactionResponse> mapModelToResponseDtoGroupByProfileId(List<Transaction> transactions) {
		List<CustomerProfileTransactionResponse> out = new ArrayList<>();
		
		Map<Integer,CustomerProfileTransactionResponse> outMap = new HashMap<>();
		
		transactions.stream().forEach(t -> {
			if(outMap.get(t.getProfile().getProfileId())!=null) {
				CustomerProfileTransactionResponse custProf = outMap.get(t.getProfile().getProfileId());
				List<TransactionResponse> trns = custProf.getTransactions();
				mapTransactionsResponse(trns, t);
			} else {
				CustomerProfileTransactionResponse custProf = modelMapper.map(t.getProfile(),
						CustomerProfileTransactionResponse.class);
				List<TransactionResponse> trns = new ArrayList<>();
				mapTransactionsResponse(trns, t);
				outMap.put(t.getProfile().getProfileId(),custProf);
			}
		});
		
		outMap.forEach((k,v)->{outMap.get(k); out.add(v);});
		
		return out;
	}
	
	/**
	 * 
	 * @param transactions
	 * @return
	 */
	public CustomerProfileTransactionResponse mapModelToResponseDto(List<Transaction> transactions) {
		CustomerProfileTransactionResponse resp = modelMapper.map(transactions.get(0).getProfile(),
				CustomerProfileTransactionResponse.class);
		List<TransactionResponse> trns = new ArrayList<>();
		transactions.stream().forEach(t -> mapTransactionsResponse(trns, t));
		resp.setTransactions(trns);
		return resp;
	}

	/**
	 * 
	 * @param amtSpent
	 * @return
	 */
	public double findRewardPoints(double amtSpent) {

		double rPoints = 0;
		if (amtSpent > 50) {
//			2x$20 + 1x$50
			rPoints = (amtSpent % 100) * 2;
			rPoints += ((amtSpent - (amtSpent % 100)) - 50);
		}

		return rPoints;
	}

	/**
	 * 
	 * @param trns
	 * @param t
	 */
	private void mapTransactionsResponse(List<TransactionResponse> trns, Transaction t) {
		TransactionResponse tr = new TransactionResponse();
		tr.setAmountSpent(t.getAmountSpent());
		tr.setRewardPoints(t.getRewardPoints());
		tr.setTransactionDate(t.getTransactionDate());
		tr.setTransactionId(t.getTransactionId());
		trns.add(tr);
	}

}
