 package com.cg.EmployeeManagementSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.repository.PayrollRepository;

@Service("emplyeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	PayrollRepository payrollRepository;

	@Override
	public Payroll getSalaryDetails(int id) {
		Optional<Payroll> result = payrollRepository.findById(id);
		return result.get();
		
	}

}
