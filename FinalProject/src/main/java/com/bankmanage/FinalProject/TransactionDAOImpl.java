package com.bankmanage.FinalProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class TransactionDAOImpl implements TransactionDAO{
	
	private EntityManager entityManager;
	
	
	@Autowired
	public TransactionDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public List<Transaction> showTransactionHistory(int accID){
		TypedQuery<Transaction> theQuery = entityManager.createQuery("from Transaction where account.acc_id=:accID",Transaction.class);
		theQuery.setParameter("accID",accID);
		
//		Query theQuery = entityManager.createQuery(
//				"select transId as transId, acctId as acctId, transacType as transacType, transacStatus as transacStatus, amount as amount from Transaction where user.userID=:userID");
//		theQuery.setParameter("userID", userID);
		
		List<Transaction> list = theQuery.getResultList(); 
		return list;
	}
	
	@Override
	public void save(Transaction transaction) {
		entityManager.merge(transaction);
	}

	
}