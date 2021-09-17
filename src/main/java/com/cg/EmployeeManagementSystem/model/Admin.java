package com.cg.EmployeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_details")
public class Admin {
	
	 @Id
	 @Column(name="admin_id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int adminId;
	 
	 @Column(name="admin_name")
      private String adminName;
	 
	 @Column(name="admin_name")
      private String adminPassword;
}
