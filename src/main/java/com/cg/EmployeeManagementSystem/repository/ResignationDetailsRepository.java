package com.cg.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.EmployeeManagementSystem.model.ResignationDetails;

@Repository
public interface ResignationDetailsRepository extends JpaRepository<ResignationDetails, Integer> {

}