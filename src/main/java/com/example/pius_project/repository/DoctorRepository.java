package com.example.pius_project.repository;

import com.example.pius_project.dto.DoctorDto;
import com.example.pius_project.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query(value = "select new com.example.pius_project.dto.DoctorDto(d.id, d.name, d.organization, d.specialization) from Doctor d " +
            "where (:name is null or d.name like(concat('%', :name, '%'))) "+
            "and (:organization is null or d.organization = :organization)" +
            "and (:specialization is null or d.specialization = :specialization) order by d.name")
    List<DoctorDto> findDoctorsByFilters(String name, String organization, String specialization, Pageable pageable);
}