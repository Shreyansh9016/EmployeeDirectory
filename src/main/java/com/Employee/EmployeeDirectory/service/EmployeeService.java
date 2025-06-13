package com.Employee.EmployeeDirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Employee.EmployeeDirectory.model.Employee;
import com.Employee.EmployeeDirectory.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public Employee retrieveEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Employee> getAll() {
		return repository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public void remove(int id) {
		repository.deleteById(id);
	}

	// ✅ 1. Get employees by department
	public List<Employee> getByDepartment(String dept) {
		return repository.findByDepartmentIgnoreCase(dept);
	}

	// ✅ 2. Update employee
	public Employee updateEmployee(int id, Employee updatedEmp) {
		Optional<Employee> optional = repository.findById(id);
		if (optional.isPresent()) {
			Employee existing = optional.get();
			existing.setName(updatedEmp.getName());
			existing.setEmail(updatedEmp.getEmail());
			existing.setDepartment(updatedEmp.getDepartment());
			existing.setDesignation(updatedEmp.getDesignation());
			return repository.save(existing);
		}
		return null;
	}
}
