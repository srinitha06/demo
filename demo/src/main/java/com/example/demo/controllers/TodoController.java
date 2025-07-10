package com.example.demo.controllers;

import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping("/add/{empId}")
    public String addTodo(@PathVariable int empId, @RequestBody Todo todo) {
        return todoService.addTodo(empId, todo);
    }
    @GetMapping("/employee/{empId}")
    public List<Todo>getTodos(@PathVariable int empId) {
        return todoService.getTodosByEmployee(empId);
    }
}
