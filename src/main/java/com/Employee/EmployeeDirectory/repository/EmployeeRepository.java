package com.Employee.EmployeeDirectory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.EmployeeDirectory.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByDepartmentIgnoreCase(String department);
	
}
