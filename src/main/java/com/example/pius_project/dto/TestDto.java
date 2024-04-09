package com.example.pius_project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestDto extends UserDto implements Serializable{
    String message;
}
