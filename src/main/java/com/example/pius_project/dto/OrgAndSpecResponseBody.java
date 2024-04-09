package com.example.pius_project.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class OrgAndSpecResponseBody implements Serializable {
    List<String> entities;
}
