package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// handling global exception for data not found
	
	@Value(value="${data.exception.dataNotFound}")
	public String dataNotFound;
	
	@ExceptionHandler(value=DataNotFoundException.class)
	public ResponseEntity<String> DataNotFoundException(DataNotFoundException pae)
	{
		return new ResponseEntity<String>(dataNotFound,HttpStatus.CONFLICT);
	}
	
	 
}
