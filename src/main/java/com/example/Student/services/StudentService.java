package com.example.Student.services;

import com.example.Student.models.Student;
import com.example.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int stdID) {
        return studentRepo.findById(stdID).orElse(new Student());
    }

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Student added successfully";
    }

    public String updateStudent(Student student) {
        studentRepo.save(student);
        return "Student updated successfully";
    }

    public String deleteStudentById(int stdID) {
        studentRepo.deleteById(stdID);
        return "Student deleted successfully";
    }


}
