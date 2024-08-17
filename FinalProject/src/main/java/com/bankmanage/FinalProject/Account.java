package com.bankmanage.FinalProject;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="account")
public class Account {
	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", acc_type=" + acc_type + ", balance=" + balance + "]";
	}
	@OneToMany(mappedBy="account", cascade=CascadeType.ALL)
	@JsonBackReference
	List<Transaction>t;
	@OneToOne(mappedBy="account",cascade=CascadeType.ALL)
	Customer customer;
	public Account(List<Transaction> t, Customer customer, int acc_id, String acc_type, int balance) {
		super();
		this.t = t;
		this.customer = customer;
		this.acc_id = acc_id;
		this.acc_type = acc_type;
		this.balance = balance;
	}
	public List<Transaction> getT() {
		return t;
	}
	public void setT(List<Transaction> t) {
		this.t = t;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
	private int acc_id=0;
	private String acc_type;
	private int balance;
	public Account() {
		acc_id=0;
	}
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account(int acc_id,int balance, String acc_type) {
		super();
		this.acc_id = acc_id;
		this.acc_type = acc_type;
		this.balance = balance;
	}
	
}

