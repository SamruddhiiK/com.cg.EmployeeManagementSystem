package com.cg.EmployeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
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
	
	
	@OneToOne
    @JoinColumn(name = "payroll_id", nullable = false)
	Payroll payroll;

	

	public Employee() {
		super();
	}



	public Employee(int employeeId, String employeeName, String employeePassword, String employeeEmailId,
			int employeeContactNo, String doj, Payroll payroll) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.employeeEmailId = employeeEmailId;
		this.employeeContactNo = employeeContactNo;
		this.doj = doj;
		this.payroll = payroll;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getEmployeePassword() {
		return employeePassword;
	}



	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}



	public String getEmployeeEmailId() {
		return employeeEmailId;
	}



	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}



	public int getEmployeeContactNo() {
		return employeeContactNo;
	}



	public void setEmployeeContactNo(int employeeContactNo) {
		this.employeeContactNo = employeeContactNo;
	}



	public String getDoj() {
		return doj;
	}



	public void setDoj(String doj) {
		this.doj = doj;
	}



	public Payroll getPayroll() {
		return payroll;
	}



	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + ", employeeEmailId=" + employeeEmailId + ", employeeContactNo=" + employeeContactNo
				+ ", doj=" + doj + ", payroll=" + payroll + "]";
	}
	
	
	
	
}
