package com.example.pius_project.service;

import com.example.pius_project.dto.OrgAndSpecResponseBody;
import com.example.pius_project.repository.OrganizationRepository;
import com.example.pius_project.repository.SpecializationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class OrganizationAndSpecializationService {

    private final OrganizationRepository organizationRepository;
    private final SpecializationRepository specializationRepository;

    public OrganizationAndSpecializationService(OrganizationRepository organizationRepository, SpecializationRepository specializationRepository) {
        this.organizationRepository = organizationRepository;
        this.specializationRepository = specializationRepository;
    }

    public OrgAndSpecResponseBody allOrganizations(){
        return new OrgAndSpecResponseBody(organizationRepository.findAllNames());
    }

    public OrgAndSpecResponseBody allSpecializations(){
        return new OrgAndSpecResponseBody(specializationRepository.findAllNames());
    }
}
