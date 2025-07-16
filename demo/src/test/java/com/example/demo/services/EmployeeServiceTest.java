package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.repository.RegisterDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    RegisterDetailsRepository registerDetailsRepository;

    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllEmployees() {
        RegisterDetails e1 = new RegisterDetails();
        RegisterDetails e2 = new RegisterDetails();
        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(e1, e2));
        List<RegisterDetails> list = employeeService.getMethod();
        assertEquals(2, list.size());
    }

    @Test
    void getEmployeeById() {
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpID(5);
        when(registerDetailsRepository.findById(5)).thenReturn(Optional.of(emp));
        RegisterDetails result = employeeService.getEmployeeById(5);
        assertEquals(5, result.getEmpID());
    }

//    @Test
//    void getEmployeeByRole() {
//        RegisterDetails a = new RegisterDetails();
//        a.setRole(Arrays.asList("admin"));
//        RegisterDetails b = new RegisterDetails();
//        b.setRole(Arrays.asList("user"));
//
//        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(a, b));
//        List<RegisterDetails> admins = employeeService.getUsersByRole("admin");
//        assertEquals(1, admins.size());
//        assertEquals("admin", admins.get(0).getRole().get(0));
//    }

    @Test
    void addEmployee() {
        RegisterDetails emp = new RegisterDetails();
        when(registerDetailsRepository.save(emp)).thenReturn(emp);
        String result = employeeService.addEmployee(emp);
        assertEquals("Employee added successfully", result);
    }

    @Test
    void updateEmployee() {
        RegisterDetails existing = new RegisterDetails();
        existing.setEmpID(10);
        existing.setName("Old");

        RegisterDetails updated = new RegisterDetails();
        updated.setName("New");

        when(registerDetailsRepository.findById(10)).thenReturn(Optional.of(existing));
        when(registerDetailsRepository.save(existing)).thenReturn(existing);

        String result = employeeService.updateEmployee(10, updated);
        assertEquals("Employee updated successfully", result);
    }

    @Test
    void deleteEmployee() {
        doNothing().when(registerDetailsRepository).deleteById(2);
        String result = employeeService.deleteEmployeeById(2);
        assertEquals("Employee deleted successfully", result);
    }
}
