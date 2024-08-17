package com.bankmanage.FinalProject;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
@Component
@Entity
@Table(name="transaction")
public class Transaction{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trans_id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name="acc_id")
	private Account account;
	private int acc2id;
	private String transacType;
	private String transacStatus;
	private int amount;
	public int getTrans_id() {
		return trans_id;
	}
	public Transaction(Account account,int amount, String transacType, String transacStatus,
			int acc2id){
		super();
		this.account = account;
		this.acc2id = acc2id;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.amount = amount;
	}
	public Transaction() {
		
	}
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getAcc2id() {
		return acc2id;
	}
	public void setAcc2id(int acc2id) {
		this.acc2id = acc2id;
	}
	public String getTransacType() {
		return transacType;
	}
	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}
	public String getTransacStatus() {
		return transacStatus;
	}
	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
