package com.cg.EmployeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leave_details")
public class LeaveDetails {

	@Id
	@Column(name = "leave_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;

	@Column(name = "leave_fromDate")
	private String leaveFromDate;

	@Column(name = "leave_ToDate")
	private String leaveToDate;

	@Column(name = "leave_status")
	private String leaveStatus;

	@Column(name = "totalDays")
	private int totalDays;

	public LeaveDetails() {
		super();
	}

	public LeaveDetails(int leaveId, String leaveFromDate, String leaveToDate, String leaveStatus, int totalDays) {
		super();
		this.leaveId = leaveId;
		this.leaveFromDate = leaveFromDate;
		this.leaveToDate = leaveToDate;
		this.leaveStatus = leaveStatus;
		this.totalDays = totalDays;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveFromDate() {
		return leaveFromDate;
	}

	public void setLeaveFromDate(String leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}

	public String getLeaveToDate() {
		return leaveToDate;
	}

	public void setLeaveToDate(String leaveToDate) {
		this.leaveToDate = leaveToDate;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", leaveFromDate=" + leaveFromDate + ", leaveToDate=" + leaveToDate
				+ ", leaveStatus=" + leaveStatus + ", totalDays=" + totalDays + "]";
	}

}
