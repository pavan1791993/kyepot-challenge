package com.app.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.dao.dataobject.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
