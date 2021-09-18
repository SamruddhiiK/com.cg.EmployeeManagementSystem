package com.cg.EmployeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.service.AdminService;
import com.cg.EmployeeManagementSystem.service.PayrollService;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    
    @Autowired
    PayrollService payrollService;
    
	@PostMapping(path = "/AdminLogin")
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin){
			
		Admin result = adminService.loginAdmin(admin.getAdminId(), admin.getAdminPassword());
		ResponseEntity<Admin> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/updateSalary")
	public ResponseEntity<Payroll> updateSalary(@RequestBody Payroll payroll){
		Payroll result = payrollService.updateSalary(payroll);
		ResponseEntity<Payroll> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
}
