package com.account.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.entities.Customer;
import com.account.repo.CustomerRepo;
import com.account.service.CustomerService;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo cusRepo;

	@Override
	public List<Customer> getAllCustomer() {
		return cusRepo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer cus=cusRepo.save(customer);
		return cus;
	}

}
