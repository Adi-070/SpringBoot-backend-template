package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // Combines @Controller and @ResponseBody to create a RESTful controller
@RequestMapping("/api/employees") // Maps HTTP requests to handler methods of MVC and REST controllers
public class EmployeeController {

    @Autowired // Automatically injects the EmployeeService dependency
    private EmployeeService employeeService;

    @GetMapping // Maps HTTP GET requests to specific handler methods
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}") // Maps HTTP GET requests to specific handler methods with path variables
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping // Maps HTTP POST requests to specific handler methods
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}") // Maps HTTP PUT requests to specific handler methods with path variables
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeService.getEmployeeById(id).orElseThrow();
        employee.setName(employeeDetails.getName());
        employee.setRole(employeeDetails.getRole());
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}") // Maps HTTP DELETE requests to specific handler methods with path variables
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
