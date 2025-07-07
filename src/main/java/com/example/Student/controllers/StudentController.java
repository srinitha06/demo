package com.example.Student.controllers;
import com.example.Student.models.Student;
import com.example.Student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService hws;
    @GetMapping
    public Student getMethod(@PathVariable int stdID){
        return hws.getStudentById(stdID);
    }
    @PostMapping
    public String postMethod(@RequestBody Student std){
        return hws.postMethod(std);
    }
    @PutMapping
    public String putMethod(@RequestBody Student std){
        return hws.updateRecord(std);
    }
    @DeleteMapping
    public String DeleteMethod(@PathVariable int stdID){
        return hws.deleteStudentById(stdID);
    }

}
