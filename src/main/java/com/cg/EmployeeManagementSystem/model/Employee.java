package com.cg.EmployeeManagementSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "employee_details")
public class Employee {

	@Id
	@Column(name = "employee_id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_password")
	private String employeePassword;
	
	@OneToMany
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(
		    name = "pid",
		    insertable = false,
		    updatable = false)
	List<Payroll> payroll;

	public Employee() {
		super();
	}

	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public Employee(int employeeId, String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
	}

	public Employee(int employeeId, String employeeName, String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
	}
	
	

	public List<Payroll> getPayroll() {
		return payroll;
	}

	public void setPayroll(List<Payroll> payroll) {
		this.payroll = payroll;
	}

	public Employee(int employeeId, String employeeName, String employeePassword, List<Payroll> payroll) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + ", payroll=" + payroll + "]";
	}

}
