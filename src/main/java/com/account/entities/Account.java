package com.account.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;
	private String isfc;
	private double balance;
	private boolean active;
	private AccountType accountType;

	
	@ManyToOne
	private Customer customer;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AccountTransaction> transList = new ArrayList<>();

	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getAccount() {
		return accountType;
	}

	public void setAccount(AccountType account) {
		this.accountType = account;
	}

	public String getIsfc() {
		return isfc;
	}

	public void setIsfc(String isfc) {
		this.isfc = isfc;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<AccountTransaction> getTransList() {
		return transList;
	}

	public void setTransList(List<AccountTransaction> transList) {
		this.transList = transList;
	}
	
	

	

	public Account(String isfc, double balance, boolean active, AccountType accountType) {
		super();
		this.isfc = isfc;
		this.balance = balance;
		this.active = active;
		this.accountType = accountType;
	
	}

	/*
	 * public Account(String isfc, double balance, boolean active, AccountType
	 * accountType) {
	 * 
	 * this.isfc = isfc; this.balance = balance; this.active = active;
	 * this.accountType = accountType;
	 * 
	 * 
	 * }
	 */

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Account() {
		super();		
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", isfc=" + isfc + ", balance=" + balance + ", active="
				+ active + ", accountType=" + accountType + "]";
	}

	
	

}