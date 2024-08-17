package com.bankmanage.FinalProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service

public class TransactionService {
	@Autowired
	TransactionDAOImpl transactiondao;
	@Transactional
	public void addTransaction(Transaction tran){
		transactiondao.save(tran);
	}
//	@Autowired
	 public TransactionService(TransactionDAOImpl transactiondao) {
	        this.transactiondao = transactiondao;
	    }
	@Transactional
	public List<Transaction> showLog(int acctID) {
		return transactiondao.showTransactionHistory(acctID);
	}
}
