package com.cg.EmployeeManagementSystem.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.model.LeaveDetails;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.ResignationDetails;
import com.cg.EmployeeManagementSystem.repository.EmployeeRepository;
import com.cg.EmployeeManagementSystem.repository.ResignationDetailsRepository;


@Service
public class ResignationDetailsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ResignationDetailsService.class);
	
    @Autowired
    ResignationDetailsRepository resignationRepository;
    
    @Autowired
	EmployeeRepository employeeRepository;

    
    public List<ResignationDetails> getAllResignations() throws NullPointerException {
		try {
			LOG.info("Get All Resignation Details");
			List<ResignationDetails> resignList = resignationRepository.findAll();
			return resignList;
		} catch (NullPointerException e) {
			LOG.error("Resignation Details List is empty!");
			return null;
		}

	}
    
   
    public ResignationDetails updateResignStatus(ResignationDetails resign) {
		LOG.info("Update Resign Status");
		return resignationRepository.save(resign);
	}
	
    public ResignationDetails getResignDetails(int resignId) throws NoSuchRecordException {
		Optional<ResignationDetails> result = resignationRepository.findById(resignId);
		if (!result.isEmpty()) {
			//LOG.info("Leave Details");
			return result.get();
		}
		//LOG.error("Id not found");
		throw new NoSuchRecordException("Resignation for given id does not exists!");

	}
	 
	 
}
	 

