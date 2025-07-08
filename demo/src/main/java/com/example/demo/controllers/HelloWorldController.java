package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.models.Employee;
import com.example.demo.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController

public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public String route() {
        return "welcome to springboot";
    }

   @GetMapping("/employee/{empID}")
    public Employee getMethod(@PathVariable int empID) {
        return hws.getEmployeeById(empID);
    }

    @GetMapping("/employee")
    public List<Employee> getEmployeeByJob(@PathVariable String job) {
        return hws.getEmployeeByJob(job);
    }


    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee emp) {

        hws.addEmployee(emp);
        return "added employee succesfully";
    }

    @PutMapping("/employee")
    public String putMethod(@RequestBody Employee emp){
        return hws.updateEmployee(emp);
    }
    @DeleteMapping("/employee/{empID}")
    public String DeleteMethod(@PathVariable int empID){
        return hws.deleteEmployeeById(empID);
    }
}
