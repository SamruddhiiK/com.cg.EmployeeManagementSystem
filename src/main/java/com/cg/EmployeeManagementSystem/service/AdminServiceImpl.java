package com.cg.EmployeeManagementSystem.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.Application;
import com.cg.EmployeeManagementSystem.exception.CouldNotUpdateException;
import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.exception.InvalidFieldException;
import com.cg.EmployeeManagementSystem.exception.NoRecordException;
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
		if (adminRepository.existsById(adminId)) {
			adminRepository.deleteById(adminId);
			return adminId;
		}
		LOG.error("The entered id is not exist");
		throw new NoSuchRecordException("No Such Admin Id is present");
	}

	@Override
	public Employee updateEmployee(Employee employee) throws NoSuchRecordException {
		if (employeeRepository.existsById(employee.getEmployeeId())) {
			LOG.info("Update Employee");
			Employee result = employeeRepository.save(employee);
			return result;
		} else {
			LOG.error("Employee ID Not Found!!");
			throw new NoSuchRecordException("No such id is present");
		}
	}

	@Override
	public int deleteEmployee(int employeeId) throws NoSuchRecordException{
		if (employeeRepository.existsById(employeeId)) {
			employeeRepository.deleteById(employeeId);
			return employeeId;
		}
		LOG.error("The entered id is not exist");
		throw new NoSuchRecordException("No Such employee Id is present");
	}

	@Override
	public List<Employee> getAllEmployee() throws NoRecordException {
		if(employeeRepository.count()!=0L) {
			
			LOG.info("Get All Employees");
			List<Employee> employeeList = employeeRepository.findAll();
			return employeeList;
		}
			LOG.error("Employee List is empty!");
			throw new NoRecordException("List is empty");
	}

	@Transactional
	public boolean addEmployee(Employee employee) throws InvalidFieldException {
		if (employee.getEmployeeName() != null && employee.getEmployeePassword() != null && employee.getEmployeeId() != 0) {
			boolean result = false;
			String name = employee.getEmployeeName();
			String regex = "^[A-Za-z ]+";
			if (name.matches(regex)) {
				employee = employeeRepository.save(employee);
				result = true;
				LOG.info("Employee is added successfully");
				return result;
			}

			LOG.error("incorrect details");
			throw new InvalidFieldException("Invalid");
		}
		throw new InvalidFieldException("Invalid");
	}


	@Transactional
	public boolean addAdmin(Admin admin) throws InvalidFieldException {
		if (admin.getAdminName() != null && admin.getAdminPassword() != null && admin.getAdminId() != 0) {
			boolean result = false;
			String name = admin.getAdminName();
			String regex = "^[A-Za-z ]+";
			if (name.matches(regex)) {
				admin = adminRepository.save(admin);
				result = true;
				LOG.info("Admin is added successfully");
				return result;
			}

			LOG.error("incorrect details");
			throw new InvalidFieldException("Invalid");
		}
		throw new InvalidFieldException("Invalid");
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
