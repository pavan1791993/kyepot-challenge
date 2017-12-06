package com.app.dao.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction extends BaseDataObject {
	
	private static final long serialVersionUID = 3559543012361456318L;

	@Column(name="amount")
	private long amount;
	
	@Column(name="time")
	private Date time = new Date();
	
	@Column(name="account_id",insertable=false,updatable=false)
	private Long accountId;
	
	@ManyToOne
	private Account account;

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
}
