package com.account.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.entities.Transaction;
import com.account.repo.TransactionRepo;
import com.account.service.TransactionService;


@Service
@Transactional

public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepo repo;

	@Override
	public List<Transaction> getAllTransaction() {
		return repo.findAll();
	}

}
