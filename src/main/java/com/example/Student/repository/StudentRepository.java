package com.example.Student.repository;

import com.example.Student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
