package com.example.demo.models;

public class Employee{
    private int emp_id;
    private String emp_name;
    private String emp_roll;

    public Employee(int empId, String empName, String empRoll) {
        emp_id = empId;
        emp_name = empName;
        emp_roll = empRoll;
    }

    public String getemp_roll() {
        return emp_roll;
    }

    public int getemp_id() {
        return emp_id;
    }

    public String getemp_name() {
        return emp_name;
    }

    public void setemp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setemp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setemp_roll(String emp_roll) {
        this.emp_roll = emp_roll;
    }
}
