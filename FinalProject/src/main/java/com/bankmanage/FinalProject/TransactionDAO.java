package com.bankmanage.FinalProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;


@Repository
public interface TransactionDAO {
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query("select * from Transaction where acc_id = ?1")
	public List<Transaction> showTransactionHistory(int accID);
	
	public void save(Transaction transaction);
}
