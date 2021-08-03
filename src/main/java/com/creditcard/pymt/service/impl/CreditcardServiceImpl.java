package com.creditcard.pymt.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.pymt.dao.ProfileRepository;
import com.creditcard.pymt.dao.TransactionRepository;
import com.creditcard.pymt.dto.CustomerProfileTransactionResponse;
import com.creditcard.pymt.dto.ProfileDto;
import com.creditcard.pymt.dto.TransactionDto;
import com.creditcard.pymt.exception.CreditcardProcessorException;
import com.creditcard.pymt.model.Profile;
import com.creditcard.pymt.model.Transaction;
import com.creditcard.pymt.service.CreditcardService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreditcardServiceImpl implements CreditcardService {

	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private CreditcardServiceHelper helper;
	@Autowired
	private ModelMapper modelMapper;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public ProfileDto findProfileById(int id) {
		Profile profile = profileRepository.findByProfileId(id);
		if (profile != null) {
			ProfileDto profileDto = modelMapper.map(profile, ProfileDto.class);
			return profileDto;
		}
		throw new CreditcardProcessorException("Data source exception..!","1000");
	}

	@Override
	public ProfileDto createProfile(ProfileDto profileDto) {

		Profile profile = modelMapper.map(profileDto, Profile.class);
		profile = profileRepository.save(profile);
		if (profile != null) {
			profileDto = modelMapper.map(profile, ProfileDto.class);
			return profileDto;
		}
		throw new CreditcardProcessorException("Data source exception..!","1000");
	}

	@Override
	public TransactionDto findTransactionById(int id) {
		Transaction transaction = transactionRepository.findByTransactionId(id);
		if (transaction != null) {
			TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);
			transactionDto.setProfileId(transaction.getProfile().getProfileId());
			return transactionDto;
		}
		throw new CreditcardProcessorException("Data source exception..!","1000");
	}

	@Override
	public TransactionDto createTransaction(TransactionDto transactionDto) {
		if (transactionDto != null && transactionDto.getProfileId() > 0) {
			Profile profile = profileRepository.findByProfileId(transactionDto.getProfileId());
			profile.setAvailableCreditLimit(profile.getAvailableCreditLimit() - transactionDto.getAmountSpent());
			profile.setRewardPointsEarned(profile.getRewardPointsEarned() + helper.findRewardPoints(transactionDto.getAmountSpent()));
			profileRepository.save(profile);
		}
		Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
		transaction.setRewardPoints(helper.findRewardPoints(transactionDto.getAmountSpent()));
		transaction = transactionRepository.save(transaction);
		if (transaction != null) {
			transactionDto = modelMapper.map(transaction, TransactionDto.class);
			transactionDto.setProfileId(transaction.getProfile().getProfileId());
			return transactionDto;
		}
		throw new CreditcardProcessorException("Data source exception..!","1000");
	}

	@Override
	public CustomerProfileTransactionResponse findTransactionByProfileId(int profileId) {
		List<Transaction> transactions = transactionRepository.findByProfileId(profileId);
		if (transactions != null && !transactions.isEmpty()) {
			CustomerProfileTransactionResponse resp = helper.mapModelToResponseDto(transactions);
			return resp;
		}
		throw new CreditcardProcessorException("Data source exception..!","1000");
	}

	@Override
	public CustomerProfileTransactionResponse findTransactionByProfileIdBetweenDates(int profileId, String from, String to)
			throws Exception {

		Date fromDate = formatter.parse(from);
		Date toDate = formatter.parse(to);

		List<Transaction> transactions = transactionRepository.findAllByTransactionDateBetweenAndByProfileId(fromDate,
				toDate, profileId);
		if (transactions != null && !transactions.isEmpty()) {
			CustomerProfileTransactionResponse resp = helper.mapModelToResponseDto(transactions);
			return resp;
		}
		throw new CreditcardProcessorException("Data source exception..!","1000");

	}

	@Override
	public List<CustomerProfileTransactionResponse> findLastThreeMonthsTransactionForAllCustomer() throws Exception {
		
		Calendar calendar = Calendar.getInstance();

		String tDate = formatter.format(calendar.getTime());
		Date toDate = formatter.parse(tDate);
		calendar.add(Calendar.MONTH, -3);
		String fDate = formatter.format(calendar.getTime());
		Date fromDate = formatter.parse(fDate);

		List<Transaction> transactions = transactionRepository.findAllByTransactionDateBetween(fromDate,
				toDate);
		if (transactions != null && !transactions.isEmpty()) {
			List<CustomerProfileTransactionResponse> resp = helper.mapModelToResponseDtoGroupByProfileId(transactions);
			return resp;
		}
		throw new CreditcardProcessorException("Data source exception..!","1000");
	}
	
}