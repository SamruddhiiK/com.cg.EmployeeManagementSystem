package com.cg.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.repository.AdminRepository;
import com.cg.EmployeeManagementSystem.repository.EmployeeRepository;
import com.cg.EmployeeManagementSystem.repository.PayrollRepository;


@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    
    @Autowired(required = false)
    EmployeeRepository employeeRepository;
    
    @Autowired(required = false)
    PayrollRepository payrollRepository;
    
	@Override
	public Admin loginAdmin(int adminId, String password) throws IncorrectLoginCredentialsException{
		
		 Admin admin =null;

		if (adminRepository.existsById(adminId)
				&& adminRepository.findById(adminId).get().getAdminPassword().equals(password)) {
		     admin = adminRepository.findById(adminId).get();
			//Logger.info("Admin login is  successfull");
		 	return admin;
		}
	
		throw new IncorrectLoginCredentialsException("Invalid Credentials");
	}
	 
	
	   @Override
		public int deleteAdmin(int adminId) {
		//	LOG.info("deleteAdmin");
			 adminRepository.deleteById(adminId);
			return adminId;
		}


	@Override
	public Employee updateEmployee(Employee employee) {
		
			  //LOG.info("Update");
			  return employeeRepository.save(employee);
		
	}


	@Override
	public int deleteEmployee(int employeeId) {
		try {
			  employeeRepository.deleteById(employeeId);
			  return employeeId;
		    }catch(EmptyResultDataAccessException ex) {
		    	//LOG.error("Employee ID Not Found!!");
		    	return 0;
		    }
	}


	@Override
	public List<Employee> getAllEmployee() {
		try {
			List<Employee> employeeList = employeeRepository.findAll();
		    return employeeList;
		}catch (NullPointerException e) {
			return null;
		}
		
	}


	@Override
	public Employee addEmployee(Employee employee) {
		Employee add = employeeRepository.save(employee);
		return add;
	}


	@Override
	public Admin addAdmin(Admin admin) {
		Admin result = adminRepository.save(admin);
		return result;
	}


	@Override
	public Admin getAdminById(int adminId) {
		//LOG.info("getEmployeeById " + eid);
				Optional<Admin> optAdmin = adminRepository.findById(adminId);
				/*
				 * if (optEmp.isEmpty()) throw new EmployeeNotFoundException(); else return
				 * optEmp.get();
				 */
				return optAdmin.get();
	}


	@Override
	public Employee getEmployeeById(int eid) {
		Optional<Employee> optEmp = employeeRepository.findById(eid);
		return optEmp.get();
	}


	@Override
	public Payroll updateSalary(Payroll payroll) {
		return payrollRepository.save(payroll);
	}
	
	
}
