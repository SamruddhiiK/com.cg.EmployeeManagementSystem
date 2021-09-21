package com.cg.EmployeeManagementSystem.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException() {
		// LOG.error("handleEmptyResultDataAccessException");

		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CouldNotUpdateException.class)
	public ResponseEntity<Object> handleCouldNotUpdateEmployeeException() {
		// LOG.error("handleEmptyResultDataAccessException");

		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}
}
