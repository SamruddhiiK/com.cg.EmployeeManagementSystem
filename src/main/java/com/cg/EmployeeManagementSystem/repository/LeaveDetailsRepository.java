package com.cg.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.EmployeeManagementSystem.model.LeaveDetails;

public interface LeaveDetailsRepository extends JpaRepository<LeaveDetails, Integer> {

}
