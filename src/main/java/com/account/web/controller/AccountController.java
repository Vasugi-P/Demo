package com.account.web.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entities.Account;
import com.account.entities.Customer;
import com.account.formbean.AccountBean;
import com.account.formbean.TransferForm;
import com.account.service.AccountService;
import com.account.service.CustomerService;

@RestController

public class AccountController {

	@Autowired
	private AccountService as;

	@Autowired
	private CustomerService cs;
	
	
	public AccountController(CustomerService cs) {
		super();
		this.cs = cs;
	}

	@GetMapping(path = "/account")
	public ResponseEntity<List<Account>> getAllAccount() {
		return new ResponseEntity<List<Account>>(as.getAllAccount(), HttpStatus.OK);
	}

	@GetMapping(path = "/customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<List<Customer>>(cs.getAllCustomer(), HttpStatus.OK);
	}
	
	@PostMapping(path="/trans")
	  public ResponseEntity<Account>transfer(@RequestBody TransferForm transForm){
		  as.transfer(transForm.getFromAccount(), transForm.getToAccount(),transForm.getTransactionAmount());
		  return new ResponseEntity<Account>(HttpStatus.OK);
	  }
	
	@PostMapping(path="/create")
	public ResponseEntity<Account>addAccount(@RequestBody AccountBean accountBean){
		Account acc=new Account(accountBean.getIsfc(),accountBean.getBalance(),accountBean.isActive(),accountBean.getAccountType());
		Customer cust=new Customer(accountBean.getName(),accountBean.getEmail(),accountBean.getAddress(),
				accountBean.getCity(),accountBean.getPhone(),accountBean.getCountry(),accountBean.getIsEligible());
		acc.setCustomer(cust);
		
		return new ResponseEntity<>(as.addAccount(acc),HttpStatus.OK);
	
	
}

}
