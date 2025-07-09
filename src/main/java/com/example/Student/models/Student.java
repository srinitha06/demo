package com.example.Student.models;

public class Student {
    private int stdID;
    private String std_name;
    private String std_roll;

    public Student() {}

    // All-arguments constructor
    public Student(int stdID, String std_name, String std_roll) {
        this.stdID = stdID;
        this.std_name = std_name;
        this.std_roll = std_roll;
    }
    public int getStdID() {
        return stdID;
    }

    public void setStdID(int stdID) {
        this.stdID = stdID;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStd_roll() {
        return std_roll;
    }

    public void setStd_roll(String std_roll) {
        this.std_roll = std_roll;
    }


}
