package com.cg.EmployeeManagementSystem.exception;

public class CouldNotUpdateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CouldNotUpdateException(String message) {
		super(message);
	}
}
