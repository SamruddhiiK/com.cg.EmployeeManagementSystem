package com.cg.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;

public interface AdminService {

	public Admin loginAdmin(int adminId, String password);
	public Employee updateEmploye(Employee employee);
	public int deleteEmployee(int employeeId);
	public int deleteAdmin(int adminId);
	public List<Employee> getAllEmployee();
	public Employee addEmployee(Employee employee);
	public Admin addAdmin(Admin admin);
	public Admin getAdminById(int adminId);
	public Employee getEmployeeById(int eid);
}
