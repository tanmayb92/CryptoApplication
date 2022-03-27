package com.cryptoapp.portfolio.exceptionhandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<Object> handleNoElementException() {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
