package com.Employee.EmployeeDirectory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String department;
	private String designation;
	
	public Employee() {
		super();
	}
	public Employee(int id,String name,String email,String department,String designation)
	{
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.department=department;
		this.designation=designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString()
	{
		return "Employee [id=" + id + ", name=" + name +", email=" + email + ", department=" + department + ", designation=" + designation +"]";  
	}
	
}
