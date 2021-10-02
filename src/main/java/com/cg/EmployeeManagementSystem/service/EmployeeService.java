package com.cg.EmployeeManagementSystem.service;

import java.util.List;

import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.CompanyInformation;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.ResignationDetails;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;

public interface EmployeeService {
	public Payroll getSalaryDetails(int payrollId) throws NoSuchRecordException;
	
	public Employee loginEmployee(int employeeId, String password) throws IncorrectLoginCredentialsException;

	public List<YearlyHolidayList> getYearlyHoliday();

	public List<CompanyInformation> getCompanyInformation();

	public ResignationDetails addResignation(ResignationDetails resignationDetails);

}
