package com.example.Student.controllers;

import com.example.Student.models.Student;
import com.example.Student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{stdID}")
    public Student getStudentById(@PathVariable int stdID) {
        return studentService.getStudentById(stdID);
    }



    @PostMapping
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added successfully";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{stdID}")
    public String deleteStudentById(@PathVariable int stdID) {
        return studentService.deleteStudentById(stdID);
    }
}
