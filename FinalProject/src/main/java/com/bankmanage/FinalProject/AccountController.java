package com.bankmanage.FinalProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionController transactionController;

	// createAccount happens upon createCustomer
		@PostMapping("/account/{acctID}/{balance}/{acctStatus}")
		public void createAccount(@PathVariable int acctID,@PathVariable int balance,@PathVariable String acctStatus) {
			Account acct = new Account(acctID, balance, acctStatus);
			accountService.createAccount(acct);
		}

	// checkBalance
	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID) {
		return accountService.getBalance(acctID);
	}

	// depositAmount
	@PutMapping("/account/{acctID}/deposit/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.depositAmount(acctID, amount);
		Account acc1=accountService.getAccountInfo(acctID);
		Transaction transaction = new Transaction(acc1,amount,"Deposit", "Success",0);
		transactionController.addLog(transaction);
	}

	// withdrawAmount
	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.withdrawAmount(acctID, amount);
		Account acc1=accountService.getAccountInfo(acctID);
		Transaction transaction= new Transaction(acc1,amount,"Withdraw","Success",0);
		transactionController.addLog(transaction);
	}

	// transferAmount
	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}/")
	public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountService.transferAmount(acctID, destAcctID, amount);
		Account acc1=accountService.getAccountInfo(acctID);
		Transaction sender = new Transaction(acc1,amount,"Sent","Success",destAcctID);
		transactionController.addLog(sender);
		Account acc2=accountService.getAccountInfo(destAcctID);
		Transaction receiver = new Transaction(acc2,amount,"Received", "Success",acctID);
		transactionController.addLog(receiver);
	}

	// deleteAccount
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID){
		accountService.deleteAccount(acctID);
//		transactionController.deleteLog(acctID);
	}

	// getAccountInfo
	@GetMapping("/account/{acctID}")
	public Account getAccountInfo(@PathVariable int acctID) {
		return accountService.getAccountInfo(acctID);
	}
}
