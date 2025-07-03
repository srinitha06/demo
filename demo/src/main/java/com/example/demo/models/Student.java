package com.example.demo.models;

public class Student {
    private int std_id;
    private String std_name;
    private String std_roll;

    public Student(int stdId, String stdName, String stdRoll) {
        std_id = stdId;
        std_name = stdName;
        std_roll = stdRoll;
    }

    public String getStd_roll() {
        return std_roll;
    }

    public int getStd_id() {
        return std_id;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public void setStd_roll(String std_roll) {
        this.std_roll = std_roll;
    }
}
