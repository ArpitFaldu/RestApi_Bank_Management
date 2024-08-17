package com.bankmanage.FinalProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface AccountDAO extends CrudRepository<Account,Integer>,JpaRepository<Account,Integer>{
	@Query("select balance from Account where acc_id = ?1")
	public int findBalanceByAcctID(int acctID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Account set balance = balance+?2 where acc_id=?1")
	public void depositAmountByAcctID(int acctID, int balance);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Account set balance = balance-?2 where acc_id=?1")
	public void withdrawAmountByAcctID(int acctID, int balance);

}
