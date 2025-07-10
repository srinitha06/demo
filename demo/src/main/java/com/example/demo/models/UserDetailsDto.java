package com.example.demo.models;

import java.util.Set;

public class UserDetailsDto {

    private int empID;
    private String name;
    private String email;
    private String password;
    private String userName;
    private Set<String> roleNames;

    public UserDetailsDto() {
    }

    public UserDetailsDto(int empID, String name, String email, String password, String userName, Set<String> roleName) {
        this.empID = empID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.roleNames = roleNames;
    }

    public int getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public Set<String> getRoleName() {
        return roleNames;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRoleName(Set<String> roleNames) {
        this.roleNames = roleNames;
    }
}
