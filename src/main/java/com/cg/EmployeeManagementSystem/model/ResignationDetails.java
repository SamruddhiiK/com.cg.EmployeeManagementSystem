package com.cg.EmployeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Resignation_details")
public class ResignationDetails {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id")
	private int applicationId;

	@Column(name = "status")
	private String status;

	@OneToOne
	@JoinColumn(name = "ApplId")
	Employee employee;

	public ResignationDetails() {
		super();
	}

	public ResignationDetails(int applicationId, String status, Employee employee) {
		super();
		this.applicationId = applicationId;
		this.status = status;
		this.employee = employee;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ResignationDetails [applicationId=" + applicationId + ", status=" + status + ", employee=" + employee
				+ "]";
	}
	
	
	
}
