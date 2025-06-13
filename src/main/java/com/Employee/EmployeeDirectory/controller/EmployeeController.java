package com.Employee.EmployeeDirectory.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.EmployeeDirectory.model.Employee;
import com.Employee.EmployeeDirectory.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	@GetMapping("/employee/{id}")
	public Employee getEmployee( @PathVariable int id) {
		return service.retrieveEmployeeById(id);
	}
	@DeleteMapping("/employee/{id}")
	public void removeEmployee( @PathVariable int id) {
		service.remove(id);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return service.getAll();
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	@GetMapping("/employees/department/{dept}")
	public List<Employee> getByDepartment(@PathVariable String dept) {
		return service.getByDepartment(dept); 
	}
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmp) {
		return service.updateEmployee(id, updatedEmp); 
	}

}
