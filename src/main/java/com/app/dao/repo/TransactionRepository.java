package com.app.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.dao.dataobject.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
