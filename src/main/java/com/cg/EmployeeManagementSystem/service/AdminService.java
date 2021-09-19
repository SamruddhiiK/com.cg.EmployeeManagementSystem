package com.cg.EmployeeManagementSystem.service;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;

public interface AdminService {

	public Admin loginAdmin(int adminId, String password);
	public Employee updateEmploye(Employee employee);
	public int deleteEmployee(int employeeId);
}
