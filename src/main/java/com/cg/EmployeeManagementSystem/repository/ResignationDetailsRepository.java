package com.cg.EmployeeManagementSystem.repository;

 

import java.util.List;
import java.util.Optional;

 

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 


import com.cg.EmployeeManagementSystem.model.ResignationDetails;

 

@Repository
public interface ResignationDetailsRepository extends JpaRepository<ResignationDetails, Integer> {

 

    @Query(value = "select r from ResignationDetails r where r.employee.employeeId = :eid")
     public abstract Optional<ResignationDetails> findAllResignationsByEmployee(@Param("eid") int eid);
    

 

}