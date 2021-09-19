package com.cg.EmployeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.service.AdminService;
import com.cg.EmployeeManagementSystem.service.AdminServiceImpl;
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
	
	@DeleteMapping("/deleteEmp/{eid}")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable int eid){
		int id =  adminService.deleteEmployee(eid);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee e =adminService.updateEmploye(employee);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
    
	@PutMapping("/updateSalary")
	public ResponseEntity<Payroll> updateSalary(@RequestBody Payroll payroll){
		Payroll result = payrollService.updateSalary(payroll);
		ResponseEntity<Payroll> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	
	
}
