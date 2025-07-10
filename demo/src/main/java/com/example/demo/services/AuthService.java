package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Roles;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.repository.RegisterDetailsRepository;
import com.example.demo.repository.RolesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpID(register.getEmpID());
        registerDetails.setEmail(register.getEmail());

        System.out.println("Password is " + register.getPassword() +
                "\nEncrypted Password is " + passwordEncoder.encode(register.getPassword()));

        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());

        Set<Roles> roles = new HashSet<>();
        for (String roleName : register.getRoleName()) {
            Roles role = rolesRepository.findByRoleName(roleName)
                    .orElseThrow(() -> new RuntimeException("ROLE NOT FOUND: " + roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);

        registerDetailsRepository.save(registerDetails);
        return "Employee added successfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
                return "Login successful";
            }
        }
        return "Login not successful";
    }
}
