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
    @GetMapping("/{empID}")
    public Employee getMethod(@PathVariable int empID){
      return hws.getEmployeeById(empID);
    }
    @PostMapping
    public String postMethod(@RequestBody Employee emp){
      //  Employee emp=new Employee(5,"sivagami","23ec130");
        return hws.postMethod(emp);
    }
    @PutMapping
    public String putMethod(){
        return hws.putMethod();
    }
    @DeleteMapping("/{empID}")
    public String DeleteMethod(@PathVariable int empID){
        return hws.deleteEmployeeById(empID);
    }

}
