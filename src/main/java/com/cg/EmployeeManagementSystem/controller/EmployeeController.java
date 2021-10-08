package com.cg.EmployeeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem.Application;
import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.exception.InvalidFieldException;
import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.CompanyInformation;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.LeaveDetails;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.ResignationDetails;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.service.EmployeeService;
import com.cg.EmployeeManagementSystem.service.LeaveDetailsServiceImpl;
import com.cg.EmployeeManagementSystem.service.PayrollServiceImpl;
import com.cg.EmployeeManagementSystem.service.ResignationDetailsService;

@CrossOrigin(origins="*")
@RestController
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	LeaveDetailsServiceImpl leaveDetail;
	
	@Autowired
	ResignationDetailsService resignDetail;
	
	@Autowired
	PayrollServiceImpl payrollService;
	
	// http://localhost:8082/EmployeeLogin
		@PostMapping(path = "/EmployeeLogin")
		public ResponseEntity<Employee> employeeLogin(@RequestBody Employee employee) throws IncorrectLoginCredentialsException {
			LOG.info("employeeLogin Controller");
			Employee result = employeeService.loginEmployee(employee.getEmployeeId(), employee.getEmployeePassword());
			ResponseEntity<Employee> response = new ResponseEntity<>(result, HttpStatus.OK);
			return response;
		}

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
	
	@PostMapping("/addLeave")
	public ResponseEntity<LeaveDetails> addLeave(@RequestBody LeaveDetails leave) {
		LOG.info("addLeave Controller");
		LeaveDetails result = leaveDetail.addLeave(leave);
		ResponseEntity<LeaveDetails> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getLeaveDetails/{leaveId}")
	public ResponseEntity<LeaveDetails> getLeaveDetails(@PathVariable int leaveId) throws NoSuchRecordException {
		LOG.info("Get Leave Details");
		LeaveDetails leaveDetails = leaveDetail.getLeaveDetails(leaveId);
		ResponseEntity<LeaveDetails> response = new ResponseEntity<LeaveDetails>(leaveDetails, HttpStatus.OK);
		return response;
	}

	@GetMapping("/viewResignationStatus/{resignId}")
	public ResponseEntity<ResignationDetails> getResignDetails(@PathVariable int resignId) throws NoSuchRecordException {
		LOG.info("Get Resign Details");
		ResignationDetails resignDetails = resignDetail.getResignDetails(resignId);
		ResponseEntity<ResignationDetails> response = new ResponseEntity<ResignationDetails>(resignDetails, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getSalaryDetailsByEmployeeId/{employeeId}")
	public ResponseEntity<Optional<List<Payroll>>> getSalaryDetailsByEmployeeId(@PathVariable int employeeId) throws NoSuchRecordException {
		LOG.info("Get Salary Details");
		Optional<List<Payroll>> payroll = payrollService.getSalaryDetailsByEmployeeId(employeeId);
		ResponseEntity<Optional<List<Payroll>>> response = new ResponseEntity<Optional<List<Payroll>>>(payroll, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getLeaveDetailsByEmployeeId/{employeeId}")
	public ResponseEntity<Optional<List<LeaveDetails>>> getLeaveDetailsByEmployeeId(@PathVariable int employeeId) throws NoSuchRecordException {
		LOG.info("Get Leave Details");
		Optional<List<LeaveDetails>> leaveDetails = leaveDetail.getLeaveDetailsByEmpId(employeeId);
		ResponseEntity<Optional<List<LeaveDetails>>> response = new ResponseEntity<Optional<List<LeaveDetails>>>(leaveDetails, HttpStatus.OK);
		return response;
	}
}
