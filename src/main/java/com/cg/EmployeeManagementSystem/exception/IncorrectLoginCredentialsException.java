package com.cg.EmployeeManagementSystem.exception;

public class IncorrectLoginCredentialsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public IncorrectLoginCredentialsException(String message) {
		super(message);
	}
}
