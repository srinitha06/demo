package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_details")
public class RegisterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique=true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "user_name",nullable = false,unique=true)
    private String userName;

    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",joinColumns=
    @JoinColumn(name="user_id",referencedColumnName ="empID"),
           inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName="roleId"))
    private Set<Roles>roles;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public RegisterDetails() {
    }

    public RegisterDetails(int empID, String name, String email, String password,String userName, Set<Roles> roles) {
        this.empID = empID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userName=userName;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




    }

