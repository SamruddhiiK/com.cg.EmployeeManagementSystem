package com.cg.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.CompanyInformation;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getYearlyHolidayList")
	public ResponseEntity<List<YearlyHolidayList>> getYearlyHolidayList(){
		List<YearlyHolidayList> yearlyHolidayList = employeeService.getYearlyHoliday();
		ResponseEntity<List<YearlyHolidayList>> response = new ResponseEntity<List<YearlyHolidayList>>(yearlyHolidayList, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getCompanyInformation")
	public ResponseEntity<List<CompanyInformation>> getCompanyInformation(){
		List<CompanyInformation> companyInformations = employeeService.getCompanyInformation();
		ResponseEntity<List<CompanyInformation>> response = new ResponseEntity<List<CompanyInformation>>(companyInformations, HttpStatus.OK);
		return response;
	}
	
     @GetMapping("/getSalaryDetails/{payrollId}")
     public ResponseEntity<Payroll> getSalaryDetails(@PathVariable int payrollId){
       Payroll payroll = employeeService.getSalaryDetails(payrollId);
       ResponseEntity<Payroll> response = new ResponseEntity<>(payroll, HttpStatus.OK);
		return response;
    	 
    	 
     }
     
}
