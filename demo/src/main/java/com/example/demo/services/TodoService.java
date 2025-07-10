package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Todo;
import com.example.demo.repository.RegisterDetailsRepository;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;

    public String addTodo(int empId,Todo todo){
        RegisterDetails employee=registerDetailsRepository.findById(empId)
                .orElseThrow(()->new RuntimeException("Employee not found: " + empId));
        todo.setEmployee(employee);
        todoRepository.save(todo);
        return "Todo added successfully";
    }
    public List<Todo>getTodosByEmployee(int empId) {
        return todoRepository.findByEmployeeEmpID(empId);
    }
}
