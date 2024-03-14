package com.example.pius_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Organization {
    @Id
    String name;
}