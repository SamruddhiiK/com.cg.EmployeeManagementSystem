package com.cg.EmployeeManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.EmployeeManagementSystem.model.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Integer> {

	@Query(value = "select p from Payroll p where p.employee.employeeId = :eid")
	 public abstract Optional<List<Payroll>> findAllPayrollsByEmployee(@Param("eid") int eid);
	

}
