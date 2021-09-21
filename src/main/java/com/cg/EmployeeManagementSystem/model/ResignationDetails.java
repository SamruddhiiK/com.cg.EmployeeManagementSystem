package com.cg.EmployeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "Resignation_details")
public class ResignationDetails {

	@Id
	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "status")
	private String status;

	@Column(name = "employee_Id")
	private int employeeId;

	public ResignationDetails() {
		super();
	}

	public ResignationDetails(int applicationId, int employeeId) {
		super();
		this.applicationId = applicationId;
		this.employeeId = employeeId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public ResignationDetails(int applicationId, String status, int employeeId) {
		super();
		this.applicationId = applicationId;
		this.status = status;
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "ResignationDetails [applicationId=" + applicationId + ", status=" + status + ", employeeId="
				+ employeeId + "]";
	}

}
