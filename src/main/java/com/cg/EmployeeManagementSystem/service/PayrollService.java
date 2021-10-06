package com.cg.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.EmployeeManagementSystem.model.Payroll;

public interface PayrollService {
	public Payroll updateSalary(Payroll payroll);
	public Optional<List<Payroll>> getSalaryDetailsByEmployeeId (int employeeId);
}
