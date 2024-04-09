package com.example.pius_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class GetAvailableRecordsResponseBody implements Serializable {
    ArrayList<RecordView> availableRecords;
    String name;
    String specialization;
    String organization;
}