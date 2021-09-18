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
@Table(name="payroll_details")
public class Payroll {
   
	@Id
	@Column(name="payroll_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payrollId;
	
	@Column(name="employee_bankName")
	private String bankName;
	
	@Column(name="employee_bankAccountNo")
	private String bankAccountNo;
	
	@Column(name="employee_noOfWorkingDays")
	private int noOfWorkingDays;
	
	@Column(name="month")
	private String month;
	
	@Column(name="year")
	private int year;
	
	@Column(name="salary")
	private double salary;
	


	public Payroll() {
		super();
	}



	public Payroll(int payrollId, String bankName, String bankAccountNo, int noOfWorkingDays, String month, int year,
			double salary) {
		super();
		this.payrollId = payrollId;
		this.bankName = bankName;
		this.bankAccountNo = bankAccountNo;
		this.noOfWorkingDays = noOfWorkingDays;
		this.month = month;
		this.year = year;
		this.salary = salary;
	}



	public int getPayrollId() {
		return payrollId;
	}



	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}



	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public String getBankAccountNo() {
		return bankAccountNo;
	}



	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}



	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}



	public void setNoOfWorkingDays(int noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", bankName=" + bankName + ", bankAccountNo=" + bankAccountNo
				+ ", noOfWorkingDays=" + noOfWorkingDays + ", month=" + month + ", year=" + year + ", salary=" + salary
				+ "]";
	}
     
	
}
