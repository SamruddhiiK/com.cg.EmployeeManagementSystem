package com.cg.EmployeeManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.EmployeeManagementSystem.model.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Integer>{
	
	
}
