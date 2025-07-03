package com.example.demo.services;

import com.example.demo.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Student> std=new ArrayList<>(
            Arrays.asList(new Student(1,"sri","23ec159"),
                    new Student(2,"nitha","23ec111"))
    );

    public List<Student> getMethod(){
        return std;
    }

    public String postMethod(){
        return"post method";
    }

    public String putMethod(){
        return"put method";
    }

    public String deleteMethod(){
        return"delete method";
    }
}

