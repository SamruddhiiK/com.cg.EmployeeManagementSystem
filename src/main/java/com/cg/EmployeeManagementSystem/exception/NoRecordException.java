package com.cg.EmployeeManagementSystem.exception;

public class NoRecordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoRecordException (String message) {
		super(message);
	}

}
