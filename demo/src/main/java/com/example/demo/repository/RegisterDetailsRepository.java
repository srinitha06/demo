package com.example.demo.repository;

import com.example.demo.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {
RegisterDetails findByEmail(String email);

    List<RegisterDetails> findByJob(String job);
}
