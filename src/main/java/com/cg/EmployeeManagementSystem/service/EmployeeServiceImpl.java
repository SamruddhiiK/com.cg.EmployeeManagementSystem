package com.cg.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.Application;
import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.CompanyInformation;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.ResignationDetails;
import com.cg.EmployeeManagementSystem.model.YearlyHolidayList;
import com.cg.EmployeeManagementSystem.repository.CompanyInformationRepository;
import com.cg.EmployeeManagementSystem.repository.EmployeeRepository;
import com.cg.EmployeeManagementSystem.repository.PayrollRepository;
import com.cg.EmployeeManagementSystem.repository.ResignationDetailsRepository;
import com.cg.EmployeeManagementSystem.repository.YearlyHolidayRepository;

@Service("emplyeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	PayrollRepository payrollRepository;

	@Autowired(required = false)
	YearlyHolidayRepository yearlyHolidayRepository;

	@Autowired(required = false)
	CompanyInformationRepository companyInformationRepository;

	@Autowired(required = false)
	EmployeeRepository employeeRepository;

	@Autowired(required = false)
	ResignationDetailsRepository resignationDetailsRepository;

	@Override
	public Payroll getSalaryDetails(int payrollId) throws NoSuchRecordException {
		Optional<Payroll> result = payrollRepository.findById(payrollId);
		if (!result.isEmpty()) {
			LOG.info("Salary Details");
			return result.get();
		}
		LOG.error("Id not found");
		throw new NoSuchRecordException("Payroll for given id does not exists!");

	}

	@Override
	public List<YearlyHolidayList> getYearlyHoliday() {
		LOG.info("get holiday list service");
		List<YearlyHolidayList> result = yearlyHolidayRepository.findAll();
		return result;
	}

	@Override
	public List<CompanyInformation> getCompanyInformation() {
		LOG.info("get company information service");
		List<CompanyInformation> result = companyInformationRepository.findAll();
		return result;
	}

	@Override
	public ResignationDetails addResignation(ResignationDetails resignationDetails) {
		LOG.info("Add Resignation");
		ResignationDetails result = resignationDetailsRepository.save(resignationDetails);
		return result;
	}

}
