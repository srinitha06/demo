package com.example.TODO.service;
import com.example.TODO.models.Todo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {
    List<Todo> tasks = new ArrayList<>(
            Arrays.asList(
                    new Todo(1L, "Learn Spring Boot", "Yet to Start"),
                    new Todo(2L, "Build Todo App", "In Progress"),
                    new Todo(3L, "Deploy Project", "Completed")
            )
    );
    public List<Todo> getAllTasks() {
        return tasks;
    }

    public Todo getTaskById(Long id) {
        for (Todo task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return new Todo();
    }

    public String addTask(Todo todo) {
        tasks.add(todo);
        return "Task added successfully";
    }

    public String updateTask(Todo todo) {
        for (int i = 0; i < tasks.size(); i++) {
            if (todo.getId().equals(tasks.get(i).getId())) {
                tasks.set(i, todo);
                return "Task updated";
            }
        }
        return "No such task found";
    }
    public String deleteTaskById(Long id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)) {
                tasks.remove(i);
                return "Task deleted";
            }
        }
        return "No such task found";
    }
    public String moveTaskStatus(Long id, String newStatus) {
        List<String> validStatuses = List.of("Yet to Start", "In Progress", "Completed");

        if (!validStatuses.contains(newStatus)) {
            return "Invalid status. Allowed: Yet to Start, In Progress, Completed";
        }

        for (Todo task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(newStatus);
                return "Task status updated";
            }
        }
        return "Task not found";
    }
}
