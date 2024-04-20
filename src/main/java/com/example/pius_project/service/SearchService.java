package com.example.pius_project.service;

import com.example.pius_project.dto.DoctorDto;
import com.example.pius_project.dto.SearchWithFiltersRequestBody;
import com.example.pius_project.dto.SearchWithFiltersResponseBody;
import com.example.pius_project.repository.DoctorRepository;
import com.example.pius_project.repository.RecordRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final DoctorRepository doctorRepository;

    public SearchService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public SearchWithFiltersResponseBody searchWithFilters(SearchWithFiltersRequestBody body){
        List<DoctorDto> doctors = new ArrayList<>();
        Pageable pageable = PageRequest.of(body.getOffset(), body.getLimit());
        doctors = doctorRepository.findDoctorsByFilters(
                body.getName(),
                body.getOrganization(),
                body.getSpecialization(),
                pageable
        );
        return new SearchWithFiltersResponseBody(doctors, doctors.size());
    }



}
