package com.cg.EmployeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	
     @GetMapping("/getSalaryDetails/{payrollId}")
     public ResponseEntity<Payroll> getSalaryDetails(@PathVariable int payrollId){
       Payroll payroll = employeeService.getSalaryDetails(payrollId);
       ResponseEntity<Payroll> response = new ResponseEntity<>(payroll, HttpStatus.OK);
		return response;
    	 
    	 
     }
     
}
