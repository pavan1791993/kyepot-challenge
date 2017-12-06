package com.app.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.dataobject.Customer;
import com.app.service.CustomerService;

@RestController
@RequestMapping("api/customers/")
public class CustomerController extends BaseController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping(path="", method=RequestMethod.POST, consumes=MEDIA_TYPE)
	Long createCustomer(@RequestBody Customer c){
		Customer customer = service.createCustomer(c.getName(), c.getEmail());
		return customer.getId();
	}
	
	/**
	 * Only for testing
	 */
	@RequestMapping(path="", method=RequestMethod.GET, produces=MEDIA_TYPE)
	Iterable<Customer> getCustomers(){
		logger.debug("Get All Customer");
		return service.getAllCustomers();
	}
	
}
