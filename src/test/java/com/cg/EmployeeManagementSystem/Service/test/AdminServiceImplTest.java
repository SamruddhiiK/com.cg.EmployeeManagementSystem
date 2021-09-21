package com.cg.EmployeeManagementSystem.Service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.service.AdminService;

@SpringBootTest
public class AdminServiceImplTest {

	@Autowired
	AdminService adminService;

	@Test
	void testAdminLogin() {

		Admin expected = new Admin(2, "admin");
		Admin actual = adminService.loginAdmin(expected.getAdminId(), expected.getAdminPassword());
		assertEquals(expected.getAdminId(), actual.getAdminId());
		assertEquals(expected.getAdminPassword(), actual.getAdminPassword());

	}

}
