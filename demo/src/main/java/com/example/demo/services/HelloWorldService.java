package com.example.demo.services;
import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HelloWorldService {
    @Autowired
    EmployeeRepository empRepo;
    public List<Employee> getMethod() {
        return empRepo.findAll();
    }

    public Employee getEmployeeById(int empID) {

        return  empRepo.findById(empID).orElse(new Employee());
    }
    public String addEmployee(Employee employee){
        empRepo.save(employee);
        return "employee added successfully";
    }

    public String updateEmployee(Employee employee) {
        empRepo.save(employee);
        return "employee updated successfully";
    }

    public String deleteEmployeeById(int empID) {
        empRepo.deleteById(empID);
        return"deleted employee successfully";
    }

    public List<Employee >getEmployeeByJob(String job) {
        return empRepo.findByJob(job);
    }
}