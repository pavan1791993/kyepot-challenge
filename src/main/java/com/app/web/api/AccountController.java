package com.app.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.dataobject.Account;
import com.app.dao.dataobject.Customer;
import com.app.dao.dataobject.Transaction;
import com.app.service.AccountService;

@RestController
@RequestMapping("api/accounts/")
public class AccountController extends BaseController {
	
	@Autowired
	AccountService service;
	
	@RequestMapping(path="", method=RequestMethod.POST,consumes=MEDIA_TYPE)
	Long createAccount(@RequestBody Customer customer){
		Account newAccount = service.createAccount(customer);
		return newAccount.getId();
	}
	
	@RequestMapping(path="{accountId}/deposite", method=RequestMethod.PUT, consumes=MEDIA_TYPE)
	boolean depositeMoney(@PathVariable("accountId") Long accountId,@RequestBody Transaction tr){
		return service.depositeMoney(accountId, tr.getAmount());
	}
	
	@RequestMapping(path="{accountId}/withdraw", method=RequestMethod.PUT, consumes=MEDIA_TYPE)
	boolean withdrawMoney(@PathVariable("accountId") Long accountId,@RequestBody Transaction tr){
		return service.withdrawMoney(accountId, tr.getAmount());
	}
	
	@RequestMapping(path="{accountId}/", method=RequestMethod.GET)
	Account enquireAccount(@PathVariable("accountId") Long accountId){
		return service.getAccountById(accountId);
	}

}
