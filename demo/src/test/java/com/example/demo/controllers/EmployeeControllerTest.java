package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute() {
        String result = employeeController.route();
        assertEquals("Welcome to Spring Boot", result);
    }

    @Test
    void testGetMethod() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1, emp2));
        List<RegisterDetails> result = employeeController.getMethod();
        assertEquals(2, result.size());
    }

    @Test
    void testGetEmployeeById() {
        RegisterDetails emp = new RegisterDetails();
        when(employeeService.getEmployeeById(1)).thenReturn(emp);
        RegisterDetails result = employeeController.getEmployeeById(1);
        assertEquals(emp, result);
    }

    @Test
    void testGetEmployeesByRole() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(employeeService.getUsersByRole("admin")).thenReturn(Arrays.asList(emp1, emp2));
        List<RegisterDetails> result = employeeController.getEmployeesByRole("admin");
        assertEquals(2, result.size());
    }

    @Test
    void testPostMethod() {
        RegisterDetails emp = new RegisterDetails();
        when(employeeService.addEmployee(emp)).thenReturn("Employee added");
        String result = employeeController.postMethod(emp);
        assertEquals("Employee added", result);
    }

    @Test
    void testPutMethod() {
        RegisterDetails emp = new RegisterDetails();
        when(employeeService.updateEmployee(1, emp)).thenReturn("Employee updated");
        String result = employeeController.putMethod(1, emp);
        assertEquals("Employee updated", result);
    }

    @Test
    void testDeleteMethod() {
        when(employeeService.deleteEmployeeById(1)).thenReturn("Employee deleted");
        String result = employeeController.deleteMethod(1);
        assertEquals("Employee deleted", result);
    }
}
