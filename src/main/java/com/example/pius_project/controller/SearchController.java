package com.example.pius_project.controller;

import com.example.pius_project.dto.OrgAndSpecResponseBody;
import com.example.pius_project.dto.SearchWithFiltersRequestBody;
import com.example.pius_project.dto.SearchWithFiltersResponseBody;
import com.example.pius_project.repository.OrganizationRepository;
import com.example.pius_project.repository.SpecializationRepository;
import com.example.pius_project.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/doctors/search")
public class SearchController {
    private final SearchService searchService;
    private final OrganizationRepository organizationRepository;
    private final SpecializationRepository specializationRepository;

    public SearchController(SearchService searchService, OrganizationRepository organizationRepository,
                            SpecializationRepository specializationRepository) {
        this.searchService = searchService;
        this.organizationRepository = organizationRepository;
        this.specializationRepository = specializationRepository;
    }

    @PostMapping
    public SearchWithFiltersResponseBody searchWithFilters(
            @RequestBody SearchWithFiltersRequestBody body,
            @RequestHeader(name = "user-id") Long userId
            ){
        System.out.println(userId);
        return searchService.searchWithFilters(body);
    }

    @GetMapping("/organizations")
    OrgAndSpecResponseBody allOrganizations(){
        return new OrgAndSpecResponseBody(organizationRepository.findAllNames());
    }

    @GetMapping("/specializations")
    OrgAndSpecResponseBody allSpecializations(){
        return new OrgAndSpecResponseBody(specializationRepository.findAllNames());
    }
}
