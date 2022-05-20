package com.cg.exception;

//city already exist exception
public class CityDataAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//default constructor
	public CityDataAlreadyExistsException() {
		super();
	}

	//parameterized constructor
	public CityDataAlreadyExistsException(String message) {
		super(message);
	}
	

}