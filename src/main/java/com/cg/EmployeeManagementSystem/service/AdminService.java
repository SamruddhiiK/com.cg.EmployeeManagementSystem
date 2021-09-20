package com.cg.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.exception.InvalidFieldException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;

public interface AdminService {

	public Admin loginAdmin(int adminId, String password) throws IncorrectLoginCredentialsException;
	public Employee updateEmployee(Employee employee);
	public int deleteEmployee(int employeeId);
	public int deleteAdmin(int adminId);
	public List<Employee> getAllEmployee();
	public Employee addEmployee(Employee employee);
	public Admin addAdmin(Admin admin) throws InvalidFieldException;
	public Admin getAdminById(int adminId);
	public Employee getEmployeeById(int eid);
	public Payroll updateSalary(Payroll payroll);
}
