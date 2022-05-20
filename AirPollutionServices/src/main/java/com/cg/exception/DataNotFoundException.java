package com.cg.exception;

// data not found exception
public class DataNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	//default constructor
	public DataNotFoundException() {
		super();
	}
 
	//parameterized constructor
	public DataNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
