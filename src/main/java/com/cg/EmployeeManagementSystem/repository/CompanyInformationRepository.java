package com.cg.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.EmployeeManagementSystem.model.CompanyInformation;

@Repository
public interface CompanyInformationRepository extends JpaRepository<CompanyInformation, Integer>{

}
