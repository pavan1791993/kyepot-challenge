package com.app.web.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="Customer Not Found")
public class CustomerNotFound extends RuntimeException {

	private static final long serialVersionUID = -8837300372969408130L;

	public CustomerNotFound(String message){
		super(message);
	}
	
}
