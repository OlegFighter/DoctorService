package com.example.pius_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoreRecordDto implements Serializable {
    private Long recordId;
    private Long doctorId;
    private String doctorFIO;
    private LocalDateTime time;
    private String specialization;
    private String organization;
}
