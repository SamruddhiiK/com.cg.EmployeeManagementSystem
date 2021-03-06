package com.cg.EmployeeManagementSystem.Service.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.cg.EmployeeManagementSystem.model.Admin;
import com.cg.EmployeeManagementSystem.model.Employee;
import com.cg.EmployeeManagementSystem.service.AdminService;

@SpringBootTest
public class AdminServiceImplTest {

	@Autowired
	AdminService adminService;

	// Samruddhi
	@Test
	void testAdminLogin() {

		Admin expected = new Admin(16, "admin");
		Admin actual = adminService.loginAdmin(expected.getAdminId(), expected.getAdminPassword());
		assertEquals(expected.getAdminId(), actual.getAdminId());
		assertEquals(expected.getAdminPassword(), actual.getAdminPassword());

	}

	// Priyanka
	@Test
	void testAddAdmin() {

		Admin expected = new Admin(14, "Adminpq", "admin");
		boolean actual = adminService.addAdmin(expected);
		assertEquals(true, actual);

	}

	// Anjali
	@Test
	void testDeleteEmployee() {

		Employee expected = new Employee(26);
		int actual = adminService.deleteEmployee(expected.getEmployeeId());
		assertEquals(expected.getEmployeeId(), actual);
	}

	// Bhakti
	@Test
	void testDeleteAdmin() {

		Admin expected = new Admin(17);
		int actual = adminService.deleteAdmin(expected.getAdminId());
		assertEquals(expected.getAdminId(), actual);
	}

	// Pratima
	@Test
	void testAddEmployee() {

		Employee expected = new Employee(26, "yfb", "sjc");
		boolean actual = adminService.addEmployee(expected);
		assertEquals(true, actual);

	}

	// Nisha
	@Test
	void testGetAllEmployee() {
		List<Employee> actual = adminService.getAllEmployee();
		assertTrue(actual.size() > 0);
	}

}
