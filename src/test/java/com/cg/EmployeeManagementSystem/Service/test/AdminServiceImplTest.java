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

		Admin expected = new Admin(2, "admin");
		Admin actual = adminService.loginAdmin(expected.getAdminId(), expected.getAdminPassword());
		assertEquals(expected.getAdminId(), actual.getAdminId());
		assertEquals(expected.getAdminPassword(), actual.getAdminPassword());

	}

	// Priyanka
	@Test
	void testAddAdmin() {

		Admin expected = new Admin(14, "Adminpq", "admin");
		Admin actual = adminService.addAdmin(expected);
		assertEquals(expected.getAdminId(), actual.getAdminId());
		assertEquals(expected.getAdminName(), actual.getAdminName());
		assertEquals(expected.getAdminPassword(), actual.getAdminPassword());

	}

	// Anjali
	@Test
	void testDeleteEmployee() {

		Employee expected = new Employee(101);
		int actual = adminService.deleteEmployee(expected.getEmployeeId());
		assertEquals(expected.getEmployeeId(), actual);
	}

	// Bhakti
	@Test
	void testDeleteAdmin() {

		Admin expected = new Admin(2);
		int actual = adminService.deleteAdmin(expected.getAdminId());
		assertEquals(expected.getAdminId(), actual);
	}

	// Pratima
	@Test
	void testAddEmployee() {

		Employee expected = new Employee(26, "yfb", "sjc");
		Employee actual = adminService.addEmployee(expected);
		assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
		assertEquals(expected.getEmployeeName(), actual.getEmployeeName());
		assertEquals(expected.getEmployeePassword(), actual.getEmployeePassword());

	}

	// Nisha
	@Test
	void testGetAllEmployee() {
		List<Employee> actual = adminService.getAllEmployee();
		assertTrue(actual.size() > 0);
	}

}
