package com.Employee.EmployeeDirectory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Employee.EmployeeDirectory.model.Employee;
import com.Employee.EmployeeDirectory.service.EmployeeService;

@Controller
public class EmployeeControllerMVC {
    private EmployeeService service;

    public EmployeeControllerMVC(EmployeeService service) {
        super();
        this.service = service;
    }

    // Show add employee form
    @GetMapping("/employee/add")
    public String addPage(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        return "addEmployee";
    }

    // Get employee details by ID
    @GetMapping("/employee/{id}")
    public String getEmployee(Model model, @PathVariable int id) {
        Employee emp = service.retrieveEmployeeById(id);
        model.addAttribute("employee", emp);
        return "demo";
    }

    // Delete employee by ID
    @GetMapping("/employee/delete/{id}")
    public String removeEmployee(@PathVariable int id) {
        service.remove(id);
        return "redirect:/employee";
    }

    // Show all employees
    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        model.addAttribute("employees", service.getAll());
        return "index";
    }

    // Show update form for employee
    @GetMapping("/employee/update/{id}")
    public String updateEmployee(Model model, @PathVariable int id) {
        Employee emp = service.retrieveEmployeeById(id);
        model.addAttribute("employee", emp);
        return "addEmployee";
    }

    // Save or update employee
    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/employee";
    }

    // Filter employees by department
    @GetMapping("/employees/department")
    public String filterByDepartment(@RequestParam(value = "dept", required = false) String dept, Model model) {
        if (dept == null || dept.trim().isEmpty()) {
            return "redirect:/employee";
        }
        model.addAttribute("employees", service.getByDepartment(dept));
        return "index";
    }
}
