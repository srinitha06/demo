package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String title;
    private String status;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private RegisterDetails employee;

    public Todo() {}

    public Todo(String title, String status, RegisterDetails employee) {
        this.title = title;
        this.status = status;
        this.employee = employee;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RegisterDetails getEmployee() {
        return employee;
    }

    public void setEmployee(RegisterDetails employee) {
        this.employee = employee;
    }
}
