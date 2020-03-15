package com.account.service;

import java.util.List;



import com.account.entities.Customer;


public interface CustomerService {
	public List<Customer>getAllCustomer();
	
	public Customer addCustomer(Customer customer);


}
