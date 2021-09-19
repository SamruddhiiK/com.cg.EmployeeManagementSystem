package com.cg.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.EmployeeManagementSystem.model.Employee;

public abstract class EmployeeRepository implements JpaRepository<Employee, Integer> {

}
