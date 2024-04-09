package com.example.pius_project.repository;

import com.example.pius_project.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, String> {
    @Query(value = "select name from Specialization ")
    List<String> findAllNames();
}