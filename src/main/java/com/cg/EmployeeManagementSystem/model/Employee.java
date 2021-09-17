package com.cg.EmployeeManagementSystem.model;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
=======
/*
 * ...
 */
>>>>>>> 67cde267ae09a851766d0b505fb390beab9e1e84
public class Employee {
  
	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_password")
	private String employeePassword;
	
	@Column(name="employee_emailId")
	private String employeeEmailId;
	
	@Column(name="employee_contactNo")
	private int employeeContactNo;
	
	@Column(name="employee_doj")
	private String doj;
	
	@Column(name="bankName")
	private String bankName;
	
	@Column(name="bankAccountNo")
	private String bankAccountNo;
	//Payroll payroll;
}
