package com.cg.EmployeeManagementSystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem.Application;
import com.cg.EmployeeManagementSystem.exception.InvalidFieldException;
import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.CompanyInformation;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.ResignationDetails;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getYearlyHolidayList")
	public ResponseEntity<List<YearlyHolidayList>> getYearlyHolidayList() {
		LOG.info("Get Holiday List");
		List<YearlyHolidayList> yearlyHolidayList = employeeService.getYearlyHoliday();
		ResponseEntity<List<YearlyHolidayList>> response = new ResponseEntity<List<YearlyHolidayList>>(
				yearlyHolidayList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getCompanyInformation")
	public ResponseEntity<List<CompanyInformation>> getCompanyInformation() {
		LOG.info("Get Company Information");
		List<CompanyInformation> companyInformations = employeeService.getCompanyInformation();
		ResponseEntity<List<CompanyInformation>> response = new ResponseEntity<List<CompanyInformation>>(
				companyInformations, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getSalaryDetails/{payrollId}")
	public ResponseEntity<Payroll> getSalaryDetails(@PathVariable int payrollId) throws NoSuchRecordException {
		LOG.info("Get Salary Details");
		Payroll payroll = employeeService.getSalaryDetails(payrollId);
		ResponseEntity<Payroll> response = new ResponseEntity<Payroll>(payroll, HttpStatus.OK);
		return response;
	}

	@PostMapping("/addResignation")
	public ResponseEntity<ResignationDetails> addResignation(@RequestBody ResignationDetails resignationDetails) {
		LOG.info("addResignation Controller");
		ResignationDetails result = employeeService.addResignation(resignationDetails);
		ResponseEntity<ResignationDetails> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

}
