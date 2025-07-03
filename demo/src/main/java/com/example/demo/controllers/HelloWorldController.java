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
    HelloWorldService hws;
    @GetMapping("/")
    public List<Employee> getMethod(){
      return hws.getMethod();
    }
    @PostMapping("/")
    public String postMethod(){
        return hws.postMethod();
    }
    @PutMapping("/")
    public String putMethod(){
        return hws.putMethod();
    }
    @DeleteMapping("/")
    public String DeleteMethod(){
        return hws.deleteMethod();
    }

}
