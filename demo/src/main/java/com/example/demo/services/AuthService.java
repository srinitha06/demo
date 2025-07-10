package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public String addNewEmployee(RegisterDetails register) {
        RegisterDetails registerDetails=new RegisterDetails();
        registerDetails.setEmpID(register.getEmpID());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setGender(register.getGender());
        registerDetails.setRole(register.getRole());
        registerDetails.setDof(register.getDof());
        System.out.println("Password is "+register.getPassword()+"/nEncrypted Password  is" +passwordEncoder.encode(register.getPassword()));
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setEmpName(register.getEmpName());
        registerDetailsRepository.save(registerDetails);
        return "Employee added successfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user=registerDetailsRepository.findByEmail(login.getEmail());
        if(user!=null){
            if(passwordEncoder.matches(login.getPassword(), user.getPassword())){
                return "login successful";
            }

        }
        return "login  not successfull";
    }
}
