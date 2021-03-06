package com.cg.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.EmployeeManagementSystem.model.Employee;

@Repository
public abstract interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
