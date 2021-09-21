package com.cg.EmployeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Holiday_List")
public class YearlyHolidayList {

	@Id
	@Column(name = "serial_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;

	@Column(name = "date")
	private String date;

	@Column(name = "holiday")
	private String holiday;

	public YearlyHolidayList() {
		super();
	}

	public YearlyHolidayList(int serialNo, String date, String holiday) {
		super();
		this.serialNo = serialNo;
		this.date = date;
		this.holiday = holiday;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	@Override
	public String toString() {
		return "YearlyHolidayList [serialNo=" + serialNo + ", date=" + date + ", holiday=" + holiday + "]";
	}

}
