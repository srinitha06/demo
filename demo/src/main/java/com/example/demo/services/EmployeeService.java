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

//    public List<RegisterDetails> getEmployeeByJob(String job) {
//        return registerDetailsRepository.findByJob(job);
//    }

    public String addEmployee(RegisterDetails emp) {
        registerDetailsRepository.save(emp);
        return "Employee added successfully";
    }

    public String updateEmployee(int empID) {
        RegisterDetails user = registerDetailsRepository.findById(empID)
                .orElseThrow(()->new RuntimeException("No Such User Present"));
        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeById(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee deleted successfully";
    }
}
