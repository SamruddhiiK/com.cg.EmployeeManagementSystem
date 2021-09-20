package com.cg.EmployeeManagementSystem.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	

	public Employee() {
		super();
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
				+ employeePassword + "]";
	}

    


	
	
	
}
