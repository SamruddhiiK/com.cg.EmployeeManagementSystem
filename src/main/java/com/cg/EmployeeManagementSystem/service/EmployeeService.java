package com.cg.EmployeeManagementSystem.service;

import java.util.List;




import com.cg.EmployeeManagementSystem.model.CompanyInformation;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;


public interface EmployeeService {
  public Payroll getSalaryDetails(int payrollId);
  public List<YearlyHolidayList> getYearlyHoliday();
  public List<CompanyInformation> getCompanyInformation();
  
}
