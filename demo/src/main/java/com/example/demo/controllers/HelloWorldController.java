package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.models.Employee;
import com.example.demo.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/emp")
public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public List<Employee> getMethod() {
        return hws.getMethod();
    }

   @GetMapping("/{empID}")
    public Employee getMethod(@PathVariable int empID) {
        return hws.getEmployeeById(empID);
    }

    @GetMapping("/job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job) {
        return hws.getEmployeeByJob(job);
    }


    @PostMapping("/")
    public String postMethod(@RequestBody Employee emp) {

        hws.addEmployee(emp);
        return "added employee succesfully";
    }

    @PutMapping
    public String putMethod(@RequestBody Employee emp){
        return hws.updateEmployee(emp);
    }
    @DeleteMapping("/{empID}")
    public String DeleteMethod(@PathVariable int empID){
        return hws.deleteEmployeeById(empID);
    }
}
