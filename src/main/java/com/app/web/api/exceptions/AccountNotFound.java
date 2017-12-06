package com.app.web.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="Account Not Found")
public class AccountNotFound extends RuntimeException {

	private static final long serialVersionUID = -8837300372969408130L;

	public AccountNotFound(String message){
		super(message);
	}
	
}
