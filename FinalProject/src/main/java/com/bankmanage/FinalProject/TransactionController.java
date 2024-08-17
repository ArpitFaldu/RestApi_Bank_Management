package com.bankmanage.FinalProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Query;

@RestController
@Component
public class TransactionController {
	@Autowired
	private Transaction tran;
	@Autowired
	private TransactionService transervice;
	// addLog
	public void addLog(Transaction transaction) {
		transervice.addTransaction(transaction);
	}

	// showLog
	@GetMapping("/account/{acctID}/logs")
	public List<Transaction> showLog(@PathVariable int acctID) {
		return transervice.showLog(acctID);
	}

}
