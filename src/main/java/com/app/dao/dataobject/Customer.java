package com.app.dao.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer extends BaseDataObject {

	private static final long serialVersionUID = 2527280095867918907L;

	@Column(name="name")
	private String name;
	
	@Column(name="email", unique=true)
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
