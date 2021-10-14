package com.cg.EmployeeManagementSystem.controller;

import java.util.List;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem.Application;


import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.exception.InvalidFieldException;
import com.cg.EmployeeManagementSystem.exception.NoRecordException;
import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.LeaveDetails;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.ResignationDetails;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.service.AdminService;
import com.cg.EmployeeManagementSystem.service.AdminServiceImpl;
import com.cg.EmployeeManagementSystem.service.LeaveDetailsServiceImpl;
import com.cg.EmployeeManagementSystem.service.PayrollService;
import com.cg.EmployeeManagementSystem.service.ResignationDetailsService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@CrossOrigin(origins="*")
@RestController
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService adminService;

	@Autowired
	PayrollService payrollService;
	
	@Autowired
	ResignationDetailsService resignationService;
	
	@Autowired
	LeaveDetailsServiceImpl leaveService;

	// http://localhost:8082/AdminLogin  --done
	@PostMapping(path = "/AdminLogin")
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin) throws IncorrectLoginCredentialsException {
		LOG.info("adminLogin Controller");
		Admin result = adminService.loginAdmin(admin.getAdminId(), admin.getAdminPassword());
		ResponseEntity<Admin> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	// http://localhost:8082/deleteAdmin/{Id}
	@DeleteMapping("/deleteAdmin/{AdminId}")
	public ResponseEntity<Integer> deleteAdmin(@PathVariable int AdminId) throws NoSuchRecordException {
		LOG.info("deleteAdmin Controller");
		int result = adminService.deleteAdmin(AdminId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// http://localhost:8082/getAllEmployee
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() throws NoRecordException {
		LOG.info("getAllEmployee Controller");
		List<Employee> employeeList = adminService.getAllEmployee();
		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		return response;
	}

	// http://localhost:8082//deleteEmp/{eid}
	@DeleteMapping("/deleteEmp/{eid}")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable int eid) throws NoSuchRecordException {
		LOG.info("deleteEmployee Controller");
		int id = adminService.deleteEmployee(eid);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}

	// http://localhost:8082//updateEmployee
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws NoSuchRecordException {
		LOG.info("updateEmployee Controller");
		Employee e = adminService.updateEmployee(employee);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	// http://localhost:8082//addAdmin
	@PostMapping("/addAdmin")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
		LOG.info("addAdmin");
		 ResponseEntity<String>response=null;
		if(adminService.addAdmin(admin)) {
		response= new ResponseEntity<String>(admin.toString(), HttpStatus.OK);
	}
		return response;
	}


	// http://localhost:8082//addEmployee --done
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		LOG.info("addEmployee");
		 ResponseEntity<String>response=null;
		if(adminService.addEmployee(employee)) {
		response= new ResponseEntity<String>(employee.toString(), HttpStatus.OK);
	}
		return response;
	}


	// http://localhost:8082//getAdminById{adminId}
	@GetMapping("/getAdminById{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int adminId) {

		LOG.info("getAdminById");
		Admin admin = adminService.getAdminById(adminId);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	// http://localhost:8082//getEmployeeById{eid}
	@GetMapping("/getEmployeeById{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int eid) throws NoSuchRecordException {
		LOG.info("getEmployeeById");
		Employee emp = adminService.getEmployeeById(eid);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	// http://localhost:8082//updateSalary
	@PutMapping("/updateSalary")
	public ResponseEntity<Payroll> updateSalary(@RequestBody Payroll payroll) {
		LOG.info("updateSalary Controller");
		Payroll result = payrollService.updateSalary(payroll);
		ResponseEntity<Payroll> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	// http://localhost:8082/getAllResignations
		@GetMapping("/getAllResignations")
		public ResponseEntity<List<ResignationDetails>> getAllResignations() throws NullPointerException {
			LOG.info("getAllResignations Controller");
			List<ResignationDetails> resignationsList = resignationService.getAllResignations();
			ResponseEntity<List<ResignationDetails>> response = new ResponseEntity<List<ResignationDetails>>(resignationsList, HttpStatus.OK);
			return response;
		}
	
	// http://localhost:8082//UpdateResignationStatus
	@PutMapping("/updateResignationStatus")
	public ResponseEntity<ResignationDetails> updateResignationStatus(@RequestBody ResignationDetails resignationDetails) {
		LOG.info("updateResign Controller");
		ResignationDetails result = resignationService.updateResignStatus(resignationDetails);
		ResponseEntity<ResignationDetails> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	// http://localhost:8082/getAllLeaves
			@GetMapping("/getAllLeaves")
			public ResponseEntity<List<LeaveDetails>> getAllLeaves() throws NullPointerException {
				LOG.info("getAllLeaveDetails Controller");
				List<LeaveDetails> leaveList = leaveService.getAllLeaves();
				ResponseEntity<List<LeaveDetails>> response = new ResponseEntity<List<LeaveDetails>>(leaveList, HttpStatus.OK);
				return response;
			}
			
			
			// http://localhost:8082//UpdateLeaveStatus
			@PutMapping("/updateLeaveStatus")
			public ResponseEntity<LeaveDetails> updateLeaveStatus(@RequestBody LeaveDetails leaveDetails) {
				LOG.info("updateLeave Controller");
				LeaveDetails result = leaveService.updateLeaveStatus(leaveDetails);
				ResponseEntity<LeaveDetails> response = new ResponseEntity<>(result, HttpStatus.OK);
				return response;
			}
			
			
}
