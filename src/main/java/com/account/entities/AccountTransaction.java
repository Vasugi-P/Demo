package com.account.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accountTrans")
public class AccountTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double balance;
	private String accountType;
	private LocalDate transactionDate;
	
	@ManyToOne
	private Account account;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountTransaction(double balance, String accountType, LocalDate transactionDate, Account account) {
		super();
		this.balance = balance;
		this.accountType = accountType;
		this.transactionDate = transactionDate;
		this.account = account;
	}

	/*
	 * public AccountTransaction() { super(); // TODO Auto-generated constructor
	 * stub }
	 * 
	 * @Override public String toString() { return
	 * "AccountTransaction [accountNumber=" + accountNumber + ", balance=" + balance
	 * + ", accountType=" + accountType + ", transactionDate=" + transactionDate +
	 * ", account=" + account + "]"; }
	 */
		
	
	
	

}