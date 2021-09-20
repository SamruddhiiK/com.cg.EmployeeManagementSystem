package com.cg.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.model.CompanyInformation;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;


public interface EmployeeService {
  public Payroll getSalaryDetails(int id);
  public List<YearlyHolidayList> getYearlyHoliday();
  public List<CompanyInformation> getCompanyInformation();
}
