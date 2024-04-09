package com.example.pius_project.repository;

import com.example.pius_project.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, String> {

    @Query(value = "select name from Organization")
    List<String> findAllNames();
}