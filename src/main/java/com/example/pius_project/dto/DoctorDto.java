package com.example.pius_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DoctorDto {
    long id;
    String name;
    String organization;
    String specialization;


    public DoctorDto(long id, String name, String organization, String specialization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.specialization = specialization;
    }
}
