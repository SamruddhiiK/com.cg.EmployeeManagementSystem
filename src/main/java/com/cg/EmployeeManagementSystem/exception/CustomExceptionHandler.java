package com.cg.EmployeeManagementSystem.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import com.cg.EmployeeManagementSystem.exception.ErrorResponse;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.ObjectError;



//@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(EmptyResultDataAccessException.class)
//	public ResponseEntity<Object> handleEmptyResultDataAccessException() {
//		// LOG.error("handleEmptyResultDataAccessException");
//
//		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
//	}

//	@ExceptionHandler(CouldNotUpdateException.class)
//	public ResponseEntity<Object> handleCouldNotUpdateEmployeeException() {
//		// LOG.error("handleEmptyResultDataAccessException");
//
//		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
//	}
	@ExceptionHandler(NoSuchRecordException.class)
	public ResponseEntity<Object> handleNoSuchRecordException() {
		// LOG.error("handleEmptyResultDataAccessException");

		return new ResponseEntity<Object>("No such id is present", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidFieldException.class)
	public ResponseEntity<Object> handleInvalidFieldException() {
		//LOG.error("handleInvalidFieldException");

		return new ResponseEntity<Object>("Details are Incorrect", HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(NoRecordException.class)
	public ResponseEntity<Object> handleNoRecordException() {
		//LOG.error("handleInvalidFieldException");

		return new ResponseEntity<Object>("List is empty", HttpStatus.NOT_FOUND);

	}
	
}