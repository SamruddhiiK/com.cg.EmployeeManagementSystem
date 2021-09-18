package com.cg.EmployeeManagementSystem.service;

import com.cg.EmployeeManagementSystem.model.Admin;

public interface AdminService {

	public Admin loginAdmin(int adminId, String password);
}
