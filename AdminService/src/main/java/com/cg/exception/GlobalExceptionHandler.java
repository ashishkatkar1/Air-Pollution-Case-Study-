package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//global exception handling for city already exist
	@Value(value="${data.exception.dataExists}")
	public String dataExists;
	
	@ExceptionHandler(value=CityDataAlreadyExistsException.class)
	public ResponseEntity<String> PopulationDataAlreadyExistsException(CityDataAlreadyExistsException pae)
	{
		return new ResponseEntity<String>(dataExists,HttpStatus.CONFLICT);
	}
	
	//global exception handling for data not found

	@Value(value="${data.exception.dataNotFound}")
	public String dataNotFound;
	
	@ExceptionHandler(value=DataNotFoundException.class)
	public ResponseEntity<String> DataNotFoundException(DataNotFoundException pae)
	{
		return new ResponseEntity<String>(dataNotFound,HttpStatus.CONFLICT);
	}
	
	 
}
