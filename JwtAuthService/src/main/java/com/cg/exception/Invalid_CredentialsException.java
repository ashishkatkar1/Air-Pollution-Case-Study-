package com.cg.exception;

//exception for invalid exception
public class Invalid_CredentialsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//default constructor
	public Invalid_CredentialsException() {
		super();
	}

	//paraemterized constructor
	public Invalid_CredentialsException(String message) {
		super(message);
	}

}
