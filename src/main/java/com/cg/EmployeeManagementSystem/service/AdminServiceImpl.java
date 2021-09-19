package com.cg.EmployeeManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.repository.AdminRepository;
import com.cg.EmployeeManagementSystem.repository.EmployeeRepository;


@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
	@Override
	public Admin loginAdmin(int adminId, String password) {
		
		 Admin admin =null;

		if (adminRepository.existsById(adminId)
				&& adminRepository.findById(adminId).get().getAdminPassword().equals(password)) {
		     admin = adminRepository.findById(adminId).get();
			//Logger.info("Admin login is  successfull");
			
		}
		return admin;
		
	}
	
	public int deleteEmployee(int eid) {
	    //LOG.info("Delete");
	    try {
	    	 employeeRepository.deleteById(eid);
		  return eid;
	    }catch(EmptyResultDataAccessException ex) {
	    	//LOG.error("Employee ID Not Found!!");
	    	return 0;
	    }
	}
	
	 

	@Override
	public Employee updateEmploye(Employee employee) {
		return employeeRepository.save(employee);
	}


	
}
