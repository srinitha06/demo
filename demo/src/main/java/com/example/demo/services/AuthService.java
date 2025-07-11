package com.example.demo.services;

import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Roles;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.repository.RegisterDetailsRepository;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.repository.RolesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService {
    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;


    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpID(register.getEmpID());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
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

//    public String authenticate(RegisterDetails login) {
//        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
//        if (user != null) {
//            if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
//                return "Login successful";
//            }
//        }
//        return "Login not successful";
//    }

    public String updateUser(int id, UserDetailsDto register) {
        RegisterDetails user = registerDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("ID NOT FOUND: " + id));
        ;
        user.setName(register.getName());
        user.setEmail(register.getEmail());
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        user.setUserName(register.getUserName());
        Set<Roles> newRoles = new HashSet<>();
        for (String roleName : register.getRoleName()) {
            Roles role = rolesRepository.findByRoleName(roleName).orElseThrow(() -> new RuntimeException("ROLE NOT FOUND: " + roleName));
            newRoles.add(role);
        }
        user.setRoles(newRoles);
        registerDetailsRepository.save(user);
        return "User updated successfully";
    }

    public List<RegisterDetails>getUsersByRole(String roleName) {
        Roles role=rolesRepository.findByRoleName(roleName)
                .orElseThrow(()->new RuntimeException("ROLE NOT FOUND: "+roleName));
        List<RegisterDetails>users=new ArrayList<>();
        for (RegisterDetails user : registerDetailsRepository.findAll()) {
            for (Roles roles : user.getRoles()) {
                if (roles.getRoleName().equals(role.getRoleName())) {
                    users.add(user);
                    break;
                }
            }
        }
        return users;
    }


    public String authenticate(RegisterDetails login) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getUserName(),login.getPassword()));
        return jwtTokenProvider.generateToken(authentication);
    }
    public Optional<RegisterDetails>getUserByUsername(String username){
        return  registerRepository.findByUserName(username);
    }
}








