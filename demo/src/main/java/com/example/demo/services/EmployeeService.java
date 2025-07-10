package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }

    public RegisterDetails getEmployeeById(int empID) {
        return registerDetailsRepository.findById(empID).orElse(new RegisterDetails());
    }

    public List<RegisterDetails> getEmployeeByJob(String job) {
        return registerDetailsRepository.findByJob(job);
    }

    public String addEmployee(RegisterDetails emp) {
        registerDetailsRepository.save(emp);
        return "Employee added successfully";
    }

    public String updateEmployee(RegisterDetails emp) {
        RegisterDetails user = registerDetailsRepository.findById(emp.getEmpID())
                .orElseThrow(() -> new RuntimeException("No user found"));
        registerDetailsRepository.save(emp);
        return "Employee updated successfully";
    }

    public String deleteEmployeeById(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee deleted successfully";
    }
}
