package com.account.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.entities.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	List<Transaction> findByfromAccount(Long fromAccount);
}