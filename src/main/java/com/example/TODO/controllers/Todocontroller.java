package com.example.TODO.controllers;
import com.example.TODO.models.Todo;
import com.example.TODO.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class Todocontroller {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTasks() {
        return todoService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Todo getTaskById(@PathVariable Long id) {
        return todoService.getTaskById(id);
    }

    @PostMapping
    public String addTask(@RequestBody Todo todo) {
        return todoService.addTask(todo);
    }

    @PutMapping
    public String updateTask(@RequestBody Todo todo) {
        return todoService.updateTask(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return todoService.deleteTaskById(id);
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        return todoService.moveTaskStatus(id, status);
    }
}
