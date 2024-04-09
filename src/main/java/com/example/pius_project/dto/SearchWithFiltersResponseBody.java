package com.example.pius_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SearchWithFiltersResponseBody {
    List<DoctorDto> doctors;
    int count;
}
