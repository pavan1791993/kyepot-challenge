package com.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.dataobject.Customer;
import com.app.dao.repo.AccountRepository;
import com.app.dao.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	AccountRepository accountRepo;
	
	private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public Customer createCustomer(String name,String email){
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customerRepo.save(customer);
		logger.info("Saved Customer : {}",customer);
		return customer;
	}
	
	public Iterable<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}

}
