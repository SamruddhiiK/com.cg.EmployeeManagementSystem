package com.cg.EmployeeManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.repository.AdminRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    
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

}
