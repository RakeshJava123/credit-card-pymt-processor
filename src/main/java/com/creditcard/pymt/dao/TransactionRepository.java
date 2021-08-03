package com.creditcard.pymt.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.creditcard.pymt.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	Transaction findByTransactionId(int transactionId);

	@Query(value = "select * from transaction where profile_id = :profileId and transaction_date >= :dateTimeStart and transaction_date <= :dateTimeEnd", nativeQuery = true)
	List<Transaction> findAllByTransactionDateBetweenAndByProfileId(@Param("dateTimeStart")Date dateTimeStart, @Param("dateTimeEnd")Date dateTimeEnd, int profileId);
	
	@Query(value = "select * from transaction where transaction_date >= :dateTimeStart and transaction_date <= :dateTimeEnd", nativeQuery = true)
	List<Transaction> findAllByTransactionDateBetween(@Param("dateTimeStart")Date dateTimeStart, @Param("dateTimeEnd")Date dateTimeEnd);

	@Query(value = "select * from transaction where profile_id = :profileId", nativeQuery = true)
	List<Transaction> findByProfileId(int profileId);
}

