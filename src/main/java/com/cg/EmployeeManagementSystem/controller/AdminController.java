package com.cg.EmployeeManagementSystem.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem.Application;

import com.cg.EmployeeManagementSystem.exception.CouldNotUpdateException;
import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.exception.InvalidFieldException;
import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.service.AdminService;
import com.cg.EmployeeManagementSystem.service.AdminServiceImpl;
import com.cg.EmployeeManagementSystem.service.PayrollService;

@RestController
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService adminService;

	@Autowired
	PayrollService payrollService;

	@PostMapping(path = "/AdminLogin")
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin) throws IncorrectLoginCredentialsException {
		LOG.info("adminLogin Controller");
		Admin result = adminService.loginAdmin(admin.getAdminId(), admin.getAdminPassword());
		ResponseEntity<Admin> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	// http://localhost:8082/deleteAdmin/{Id}
	@DeleteMapping("/deleteAdmin/{AdminId}")
	public int deleteAdmin(@PathVariable int AdminId) throws NoSuchRecordException {
		LOG.info("deleteAdmin Controller");
		int result = adminService.deleteAdmin(AdminId);
		return result;
	}

	// http://localhost:8082/getAllEmployee
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() throws NullPointerException {
		LOG.info("getAllEmployee Controller");
		List<Employee> employeeList = adminService.getAllEmployee();
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/deleteEmp/{eid}")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable int eid) throws EmptyResultDataAccessException {
		LOG.info("deleteEmployee Controller");
		int id = adminService.deleteEmployee(eid);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws CouldNotUpdateException {
		LOG.info("updateEmployee Controller");
		Employee e = adminService.updateEmployee(employee);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws InvalidFieldException {
		LOG.info("addAdmin Controller");
		Admin result = adminService.addAdmin(admin);
		ResponseEntity<Admin> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		LOG.info("addEmployee Controller");
		Employee result = adminService.addEmployee(employee);
		ResponseEntity<Employee> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getAdminById{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int adminId) {

		LOG.info("getAdminById");
		Admin admin = adminService.getAdminById(adminId);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@GetMapping("/getEmployeeById{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int eid) throws NoSuchRecordException {
		LOG.info("getEmployeeById");
		Employee emp = adminService.getEmployeeById(eid);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@PutMapping("/updateSalary")
	public ResponseEntity<Payroll> updateSalary(@RequestBody Payroll payroll) {
		LOG.info("updateSalary Controller");
		Payroll result = payrollService.updateSalary(payroll);
		ResponseEntity<Payroll> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

}
