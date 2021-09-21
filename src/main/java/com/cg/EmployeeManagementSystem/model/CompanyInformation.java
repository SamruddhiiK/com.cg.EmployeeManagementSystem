package com.cg.EmployeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_information")
public class CompanyInformation {

	@Id
	@Column(name = "company_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "date_of_establishment")
	private String dateOfEstablishment;

	@Column(name = "no_of_employees")
	private int noOfEmployees;

	@Column(name = "official_website")
	private String officialWebsite;

	public CompanyInformation() {
		super();
	}

	public CompanyInformation(int companyId, String companyName, String dateOfEstablishment, int noOfEmployees,
			String officialWebsite) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.dateOfEstablishment = dateOfEstablishment;
		this.noOfEmployees = noOfEmployees;
		this.officialWebsite = officialWebsite;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDateOfEstablishment() {
		return dateOfEstablishment;
	}

	public void setDateOfEstablishment(String dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getOfficialWebsite() {
		return officialWebsite;
	}

	public void setOfficialWebsite(String officialWebsite) {
		this.officialWebsite = officialWebsite;
	}

	@Override
	public String toString() {
		return "CompanyInformation [companyId=" + companyId + ", companyName=" + companyName + ", dateOfEstablishment="
				+ dateOfEstablishment + ", noOfEmployees=" + noOfEmployees + ", officialWebsite=" + officialWebsite
				+ "]";
	}

}
