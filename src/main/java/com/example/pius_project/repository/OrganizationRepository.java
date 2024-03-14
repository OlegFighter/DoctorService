package com.example.pius_project.repository;

import com.example.pius_project.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, String> {
}