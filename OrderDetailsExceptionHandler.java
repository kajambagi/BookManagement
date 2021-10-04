package com.demo.book.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderDetailsExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<OrderDetailsErrorResponse> handleException(OrderDetailsNotFoundException exception) {
		OrderDetailsErrorResponse error = new OrderDetailsErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}

	@ExceptionHandler
	public ResponseEntity<OrderDetailsErrorResponse> handleException(OrderDetailsFoundException exception) {
		OrderDetailsErrorResponse error = new OrderDetailsErrorResponse();
		
		error.setStatus(HttpStatus.FOUND.value());
		error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.FOUND); // 302 Found  
	}

}
