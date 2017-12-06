package com.app.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.dao.dataobject.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	Customer findByNameAndEmail(String name, String email);
	
}
