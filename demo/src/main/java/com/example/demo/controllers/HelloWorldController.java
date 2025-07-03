package com.example.demo.controllers;

import com.example.demo.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/")
    public String hello(){
      return hws.helloWorld();
    }
}
