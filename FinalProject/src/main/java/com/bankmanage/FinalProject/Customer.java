package com.bankmanage.FinalProject;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cust_id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="acc_id")
	private Account account;
	private String cust_name;
	private String phoneNo;
	private String city;
	private String country;
	private String email;
	public Customer() {
		
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer(int cust_id, Account account, String cust_name, String phoneNo, String city, String country,
			String email) {
		super();
		this.cust_id = cust_id;
		this.account = account;
		this.cust_name = cust_name;
		this.phoneNo = phoneNo;
		this.city = city;
		this.country = country;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
