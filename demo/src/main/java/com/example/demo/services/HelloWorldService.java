package com.example.demo.services;

import com.example.demo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> employees = new ArrayList<>(
            Arrays.asList(new Employee(1, "sri", "23ec151"),
                    new Employee(2, "nitha", "23ec159")
            ));

    public List<Employee> getMethod() {
        return employees;
    }

    public String postMethod(Employee emp) {
        employees.add(emp);
        return "employee added successfully";
    }



    public Employee getEmployeeById(int empID) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (empID == employees.get(i).getEmpID()) {
                System.out.println("Emp_ID: " + employees.get(i).getEmpID() + employees.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return employees.get(ind);
        } else {
            return new Employee();
        }
    }

    public String deleteEmployeeById(int empID) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (empID == employees.get(i).getEmpID()) {
                System.out.println("Emp_ID: " + employees.get(i).getEmpID() + employees.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            employees.remove(ind);
            return"employee removed";
        } else {
            return "deleted employee";
        }
    }

    public String updateRecord(Employee employee) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employee.getEmpID() == employees.get(i).getEmpID()) {
                System.out.println("Emp_ID: " + employees.get(i).getEmpID() + employees.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            employees.set(ind,employee);
            return"employee UPDATED";
        } else {
            return "NO SUCH employee PRESENT";
        }
    }
}