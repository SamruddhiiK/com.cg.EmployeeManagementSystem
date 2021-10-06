package com.cg.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
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

	public Optional<List<Payroll>> getSalaryDetailsByEmployeeId(int employeeId) throws NoSuchRecordException {
		Optional<List<Payroll>> result = payrollRepository.findAllPayrollsByEmployee(employeeId);
		if (!result.isEmpty()) {
			//LOG.info("Salary Details");
			return result;
		}
		//LOG.error("Id not found");
		throw new NoSuchRecordException("Payroll for given id does not exists!");

	}
}
