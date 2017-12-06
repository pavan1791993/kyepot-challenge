package com.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.dataobject.Account;
import com.app.dao.dataobject.Customer;
import com.app.dao.dataobject.Transaction;
import com.app.dao.repo.AccountRepository;
import com.app.dao.repo.CustomerRepository;
import com.app.dao.repo.TransactionRepository;
import com.app.web.api.exceptions.AccountNotFound;
import com.app.web.api.exceptions.CustomerNotFound;

@Service
public class AccountService {
	
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	AccountRepository accountRepo;
	@Autowired
	TransactionRepository transactionRepo;
	
	private final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	public Account getAccountById(Long id){
		return accountRepo.findOne(id);
	}
	
	public Account createAccount(Customer c){
		Customer customer = customerRepo.findByNameAndEmail(c.getName(), c.getEmail());
		if(customer==null){
			logger.warn("Creation of account failed because no customer found : {}",c);
			throw new CustomerNotFound("Customer Not Found With Name and Email");
		}
		Account account = new Account();
		account.setCustomer(customer);
		accountRepo.save(account);
		return account;
	}
	
	public boolean depositeMoney(long accountId,long amount){
		Account account = getAccount(accountId);
		Transaction tr = new Transaction();
		tr.setAccount(account);
		tr.setAccountId(account.getId());
		tr.setAmount(amount);
		transactionRepo.save(tr);
		try{
			account.setBalance(account.getBalance()+amount);
			accountRepo.save(account);
			return true;
		}catch (Exception e) {
			logger.error("{}",e);
			return false;
		}
	}
	
	public boolean withdrawMoney(Long accountId,long amount){
		Account account = getAccount(accountId);
		if(account.getBalance()>=amount){
			try{
				withdraw(account, amount);
				return true;
			}catch (Exception e) {
				logger.error("{}",e);
				return false;
			}
		}else{
			return false;
		}
	}
	
	private void withdraw(Account account,long amount){
		Transaction tr = new Transaction();
		tr.setAccount(account);
		tr.setAccountId(account.getId());
		tr.setAmount(amount*-1);
		transactionRepo.save(tr);
		
		account.setBalance(account.getBalance()-amount);
		accountRepo.save(account);
	}
	
	private Account getAccount(Long id){
		Account account = accountRepo.findOne(id);
		if(account==null){
			throw new AccountNotFound("Account Not Found");
		}
		return account;
	}

}
