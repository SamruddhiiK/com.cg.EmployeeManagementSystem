package com.cg.EmployeeManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.EmployeeManagementSystem.model.LeaveDetails;
import com.cg.EmployeeManagementSystem.model.Payroll;

public interface LeaveDetailsRepository extends JpaRepository<LeaveDetails, Integer> {
     
	@Query(value = "select l from LeaveDetails l where l.employee.employeeId = :eid")
	 public abstract Optional<List<LeaveDetails>> findAllLeavesByEmployee(@Param("eid") int eid);
}
