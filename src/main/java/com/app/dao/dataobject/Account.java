package com.app.dao.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account extends BaseDataObject {

	private static final long serialVersionUID = 8939092062614768550L;
	
	@Column(name="balance")
	private long balance;
	
	@ManyToOne
	private Customer customer;
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
