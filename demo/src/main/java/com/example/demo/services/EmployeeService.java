package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Roles;
import com.example.demo.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }



//    public List<RegisterDetails> getEmployeeByJob(String job) {
//        return registerDetailsRepository.findByJob(job);
//    }

    public String addEmployee(RegisterDetails emp) {
        registerDetailsRepository.save(emp);
        return "Employee added successfully";
    }
    public RegisterDetails getEmployeeById(int empID) {
        return registerDetailsRepository.findById(empID)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empID));
    }
    public String updateEmployee(int empID, RegisterDetails updatedEmployee) {
        RegisterDetails user = registerDetailsRepository.findById(empID)
                .orElseThrow(() -> new RuntimeException("No Such User Present"));
        user.setName(updatedEmployee.getName());
        user.setEmail(updatedEmployee.getEmail());
        user.setUserName(updatedEmployee.getUserName());
        user.setPassword(updatedEmployee.getPassword());
        user.setRoles(updatedEmployee.getRoles());
        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }
    public List<RegisterDetails> getUsersByRole(String roleName) {
        List<RegisterDetails> allUsers = registerDetailsRepository.findAll();
        List<RegisterDetails> Users = new ArrayList<>();
        for (RegisterDetails user : allUsers) {
            for (Roles role : user.getRoles()) {
                if (role.getRoleName().equalsIgnoreCase(roleName)) {
                    Users.add(user);
                    break;
                }
            }
        }

        return Users;
    }


    public String deleteEmployeeById(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee deleted successfully";
    }
}
