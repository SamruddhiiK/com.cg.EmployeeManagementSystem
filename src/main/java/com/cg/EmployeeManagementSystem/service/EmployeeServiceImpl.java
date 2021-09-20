 package com.cg.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.model.CompanyInformation;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.repository.CompanyInformationRepository;
import com.cg.EmployeeManagementSystem.repository.EmployeeRepository;
import com.cg.EmployeeManagementSystem.repository.PayrollRepository;
import com.cg.EmployeeManagementSystem.repository.YearlyHolidayRepository;

@Service("emplyeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	PayrollRepository payrollRepository;
	
	@Autowired(required = false)
	YearlyHolidayRepository yearlyHolidayRepository;
	
	
	@Autowired(required = false)
	CompanyInformationRepository companyInformationRepository;

	@Autowired(required = false)
	EmployeeRepository employeeRepository;

	@Override
	public Payroll getSalaryDetails(int payrollId) {
		Optional<Payroll> result = payrollRepository.findById(payrollId);
		return result.get();
		
	}

	@Override
	public List<YearlyHolidayList> getYearlyHoliday() {
		List<YearlyHolidayList> result = yearlyHolidayRepository.findAll();
		return result;
	}

	@Override
	public List<CompanyInformation> getCompanyInformation() {
		List<CompanyInformation> result = companyInformationRepository.findAll();
		return result;
	}

	
	

}
