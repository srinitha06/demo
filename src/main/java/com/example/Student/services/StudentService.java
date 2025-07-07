package com.example.Student.services;

import com.example.Student.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class StudentService {
    List<Student> students = new ArrayList<>(
            Arrays.asList(new Student(1, "sri", "23ec151"),
                    new Student(2, "nitha", "23ec159")
            ));
    public List<Student> getMethod() {
        return students;
    }

    public Student getStudentById(int stdID) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            if (stdID == students.get(i).getStdID()) {
                System.out.println("stdID: " + students.get(i).getStdID() + students.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return students.get(ind);
        } else {
            return new Student();
        }
    }

    public String postMethod(Student std) {
        students.add(std);
        return "employee added successfully";
    }

    public String updateRecord(Student student) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {

            if (student.getStdID() == students.get(i).getStdID()) {
                System.out.println("Emp_ID: " + students.get(i).getStdID() + students.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
             students.set(ind,student);
            return "student updated";
        } else {
            return "no such student";
        }
    }

    public String deleteStudentById(int stdID) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            if (stdID == students.get(i).getStdID()) {
                System.out.println("std_ID: " + students.get(i).getStdID() + students.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
             students.remove(ind);
             return " deleted student";
        } else {
            return "no such  student";
        }
    }
}
