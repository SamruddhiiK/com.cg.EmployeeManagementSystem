package com.cg.EmployeeManagementSystem.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.Application;
import com.cg.EmployeeManagementSystem.exception.CouldNotUpdateException;
import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.exception.InvalidFieldException;
import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.repository.AdminRepository;
import com.cg.EmployeeManagementSystem.repository.EmployeeRepository;
import com.cg.EmployeeManagementSystem.repository.PayrollRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	AdminRepository adminRepository;

	@Autowired(required = false)
	EmployeeRepository employeeRepository;

	@Autowired(required = false)
	PayrollRepository payrollRepository;

	@Override
	public Admin loginAdmin(int adminId, String password) throws IncorrectLoginCredentialsException {

		Admin admin = null;

		if (adminRepository.existsById(adminId)
				&& adminRepository.findById(adminId).get().getAdminPassword().equals(password)) {
			admin = adminRepository.findById(adminId).get();
			LOG.info("Admin login is  successfull");
			return admin;
		}
		LOG.equals("Incorrect Details");
		throw new IncorrectLoginCredentialsException("Invalid Credentials");
	}

	@Override
	public int deleteAdmin(int adminId) throws NoSuchRecordException {
		LOG.info("delete Admin");
		adminRepository.deleteById(adminId);
		return adminId;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws CouldNotUpdateException {

		LOG.info("Update Employee");
		Employee result = employeeRepository.save(employee);
		return result;
	}

	@Override
	public int deleteEmployee(int employeeId) {
		try {
			LOG.info("Employee Deleted Successfully");
			employeeRepository.deleteById(employeeId);
			return employeeId;
		} catch (EmptyResultDataAccessException ex) {
			LOG.error("Employee ID Not Found!!");
			return 0;
		}
	}

	@Override
	public List<Employee> getAllEmployee() throws NullPointerException {
		try {
			LOG.info("Get All Employees");
			List<Employee> employeeList = employeeRepository.findAll();
			return employeeList;
		} catch (NullPointerException e) {
			LOG.error("Employee List is empty!");
			return null;
		}

	}

	@Override
	public Employee addEmployee(Employee employee) {
		LOG.info("Add Employee");
		Employee add = employeeRepository.save(employee);
		return add;
	}

	@Override
	public Admin addAdmin(Admin admin) throws InvalidFieldException {
		LOG.info("Add Admin");
		Admin result = adminRepository.save(admin);
		return result;

	}

	@Override
	public Admin getAdminById(int adminId) {
		LOG.info("getEmployeeById " + adminId);
		Optional<Admin> optAdmin = adminRepository.findById(adminId);

		if (optAdmin.isEmpty()) {
			LOG.error("Admin not found");
			throw new NoSuchRecordException("Admin ID does not exist");
		} else {
			return optAdmin.get();
		}
	}

	@Override
	public Employee getEmployeeById(int eid) {
		LOG.info("Get Employee By ID");
		Optional<Employee> getEmployee = employeeRepository.findById(eid);

		if (getEmployee.isEmpty()) {
			LOG.error("Employee not found");
			throw new NoSuchRecordException("Employee ID does not exist");
		} else {
			return getEmployee.get();
		}
	}

	@Override
	public Payroll updateSalary(Payroll payroll) {
		LOG.info("Update Salary");
		return payrollRepository.save(payroll);
	}

}
