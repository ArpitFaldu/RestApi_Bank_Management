package com.bankmanage.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.bankmanage.Entity.Account;

@Service

public class AccountService {
	@Autowired
	private AccountDAO accountdao;
	public void createAccount(Account acct) {
		accountdao.save(acct);
	}

	public Account getAccountInfo(int acctID) {
		return accountdao.findById(acctID).orElse(null);
	}

	public void deleteAccount(int acctID) {
		accountdao.deleteById(acctID);
	}

	public int getBalance(int acctID) {
		return accountdao.findBalanceByAcctID(acctID);
	}

	public void depositAmount(int acctID, int amount) {
		accountdao.depositAmountByAcctID(acctID, amount);
	}

	public void withdrawAmount(int acctID, int amount) {
		accountdao.withdrawAmountByAcctID(acctID, amount);
	}

	public void transferAmount(int acctID, int destAcctID, int amount){
		accountdao.withdrawAmountByAcctID(acctID, amount);
		accountdao.depositAmountByAcctID(destAcctID, amount);
	}
}
