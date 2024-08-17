package com.bankmanage.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	@Autowired
	private CustomerDAO customerdao;

	public void createCustomer(Customer customer) {
		customerdao.save(customer);
	}

	public Customer getCustomerInfo(int custID) {
		return customerdao.findById(custID).orElse(null);
	}

	public void deleteCustomer(int custID) {
		customerdao.deleteById(custID);
	}

}
