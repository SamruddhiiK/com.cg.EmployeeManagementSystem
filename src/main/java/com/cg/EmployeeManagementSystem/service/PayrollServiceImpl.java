package com.cg.EmployeeManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.repository.PayrollRepository;

@Service("payrollService")
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	PayrollRepository payrollRepository;

	public Payroll updateSalary(Payroll payroll) {
		Payroll result = payrollRepository.save(payroll);
		return result;
	}

}
