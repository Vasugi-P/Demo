package com.account.service;

import java.util.List;

import com.account.entities.Account;

public interface AccountService {
	public List<Account> getAllAccount();
	public Account addAccount(Account account);
	void transfer(Long fromAccount,Long toAccount,double transactionAmount) ;

}
