package com.account.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.entities.AccountTransaction;


@Repository
public interface AccountTransRepo extends JpaRepository<AccountTransRepo, Long>{

	List<AccountTransaction> findByAccountNumber(Long id);
}
