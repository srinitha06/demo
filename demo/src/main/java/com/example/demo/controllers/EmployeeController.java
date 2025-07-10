package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route() {
        return "Welcome to Spring Boot";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/employee/id/{empID}")
    public RegisterDetails getMethod(@PathVariable int empID) {
        return employeeService.getEmployeeById(empID);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee/job/{job}")
    public List<RegisterDetails> getEmployeeByJob(@PathVariable String job) {
        return employeeService.getEmployeeByJob(job);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee")
    public List<RegisterDetails> getMethod() {
        return employeeService.getMethod();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody RegisterDetails emp) {
        return employeeService.addEmployee(emp);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee")
    public String putMethod(@RequestBody RegisterDetails emp) {
        return employeeService.updateEmployee(emp);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empID}")
    public String deleteMethod(@PathVariable int empID) {
        return employeeService.deleteEmployeeById(empID);
    }
}
