package com.cg.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.exception.NoSuchRecordException;
import com.cg.EmployeeManagementSystem.model.LeaveDetails;
import com.cg.EmployeeManagementSystem.model.Payroll;
import com.cg.EmployeeManagementSystem.model.ResignationDetails;
import com.cg.EmployeeManagementSystem.repository.LeaveDetailsRepository;

@Service
public class LeaveDetailsServiceImpl {
	
	@Autowired
	LeaveDetailsRepository leaveRepository;
	
	@Autowired
	LeaveDetailsRepository leaveDetailsRepository;
	
	
	public LeaveDetails addLeave(LeaveDetails leave) {
		LeaveDetails result = leaveRepository.save(leave);
		return result;
	}
	
	 public List<LeaveDetails> getAllLeaves() throws NullPointerException {
			try {
				
				List<LeaveDetails> leaveList = leaveDetailsRepository.findAll();
				return leaveList;
			} catch (NullPointerException e) {
				
				return null;
			}

		}
	 
	 public LeaveDetails updateLeaveStatus(LeaveDetails leave) {
			//LOG.info("Update Resign Status");
			return leaveDetailsRepository.save(leave);
		}
	 
	 public LeaveDetails getLeaveDetails(int leaveId) throws NoSuchRecordException {
			Optional<LeaveDetails> result = leaveDetailsRepository.findById(leaveId);
			if (!result.isEmpty()) {
				//LOG.info("Leave Details");
				return result.get();
			}
			//LOG.error("Id not found");
			throw new NoSuchRecordException("Payroll for given id does not exists!");

		}
	
	 public Optional<List<LeaveDetails>> getLeaveDetailsByEmpId(int employeeId) throws NoSuchRecordException {
			Optional<List<LeaveDetails>> result = leaveDetailsRepository.findAllLeavesByEmployee(employeeId);
			if (!result.isEmpty()) {
				//LOG.info("Salary Details");
				return result;
			}
			//LOG.error("Id not found");
			throw new NoSuchRecordException("Payroll for given id does not exists!");
	 }
}
