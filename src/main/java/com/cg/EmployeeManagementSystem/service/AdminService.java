package com.cg.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.exception.CouldNotUpdateException;
import com.cg.EmployeeManagementSystem.exception.IncorrectLoginCredentialsException;
import com.cg.EmployeeManagementSystem.exception.InvalidFieldException;
import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;

public interface AdminService {

	public Admin loginAdmin(int adminId, String password) throws IncorrectLoginCredentialsException;

	public Employee updateEmployee(Employee employee) throws CouldNotUpdateException;

	public int deleteEmployee(int employeeId) throws EmptyResultDataAccessException;

	public int deleteAdmin(int adminId) throws NoSuchRecordException;

	public List<Employee> getAllEmployee() throws NullPointerException;

	public Employee addEmployee(Employee employee);

	public Admin addAdmin(Admin admin) throws InvalidFieldException;

	public Admin getAdminById(int adminId);

	public Employee getEmployeeById(int eid) throws NoSuchRecordException;

	public Payroll updateSalary(Payroll payroll);
}
