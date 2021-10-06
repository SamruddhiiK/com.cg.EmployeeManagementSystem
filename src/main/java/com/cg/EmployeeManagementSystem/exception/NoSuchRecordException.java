package com.cg.EmployeeManagementSystem.exception;

//public class NoSuchRecordException extends RuntimeException {

	//private static final long serialVersionUID = 1L;

	//public NoSuchRecordException(String message) {
	//	super(message);
	//}
//}
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchRecordException extends RuntimeException 
{
    public NoSuchRecordException(String exception) {
        super(exception);
    }
}
