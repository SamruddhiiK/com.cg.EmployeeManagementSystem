package com.cg.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;

@Repository
public interface YearlyHolidayRepository extends JpaRepository<YearlyHolidayList, Integer> {

}
