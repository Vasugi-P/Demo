package com.account.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.entities.Account;
import com.account.entities.Transaction;
import com.account.repo.AccountRepo;
import com.account.repo.CustomerRepo;
import com.account.repo.TransactionRepo;
import com.account.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accRepo;

	@Autowired
	private CustomerRepo cusRepo;
	
	
	@Autowired
	private TransactionRepo repo1;

	@Override
	public List<Account> getAllAccount() {
		return accRepo.findAll();
	}

	@Override
	public void transfer(Long fromAccount, Long toAccount, double transactionAmount) {
		Account account = accRepo.findByAccountNumber(fromAccount);
		if (account.getBalance() - transactionAmount < 100)
			account.setBalance(account.getBalance() - transactionAmount);
		accRepo.save(account);
		Account account1 = accRepo.findByAccountNumber(toAccount);
		account1.setBalance(account1.getBalance() + transactionAmount);
		accRepo.save(account1);

		Transaction trans = new Transaction(fromAccount, toAccount, transactionAmount, "Approved");
		repo1.save(trans);
	}

	@Override
	public Account addAccount(Account account) {
		Account acc= accRepo.save(account);
		cusRepo.save(account.getCustomer());
		return acc;
	}

}
