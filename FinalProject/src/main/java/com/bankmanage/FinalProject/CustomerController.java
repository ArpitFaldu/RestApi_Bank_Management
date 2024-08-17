package com.bankmanage.FinalProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;

	@PostMapping("/customer/{id}")
	public void createCustomer(@RequestBody Customer customer,@PathVariable int id) {
		customerService.createCustomer(customer);
		Account account=accountController.getAccountInfo(id);
		if(account==null) {
			System.out.println("No such accout with that account no. is there");
		}
		else {
			System.out.println("Hi");
			customer.setAccount(account);		
			System.out.println("Hello");
		}
		
	}

	@GetMapping("/customer/{custID}")
	public Customer getCustomerInfo(@PathVariable int custID) {
		return customerService.getCustomerInfo(custID);
	}

	@DeleteMapping("/customer/{custID}")
	public void deleteCustomer(@PathVariable int custID) {
		customerService.deleteCustomer(custID);
	}
}
