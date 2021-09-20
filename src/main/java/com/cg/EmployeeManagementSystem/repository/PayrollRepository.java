package com.cg.EmployeeManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.EmployeeManagementSystem.model.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Integer>{

	
}
